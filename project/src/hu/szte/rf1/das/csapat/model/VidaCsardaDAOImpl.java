package hu.szte.rf1.das.csapat.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.szte.rf1.das.csapat.model.bean.BullShit;

public class VidaCsardaDAOImpl implements VidaCsardaDAO {

	private static File dbFile = new File(".");
	private static final String DATABASE_FILE = getParentDirPath(getParentDirPath(dbFile.getAbsolutePath())) + "\\external\\db\\VidaCsarda.db";
	
	public VidaCsardaDAOImpl() {
		try {
		    Class.forName("org.sqlite.JDBC");
		  } catch (ClassNotFoundException e) {
		    System.out.println("Failed to load SQLite JDBC drv.");
		    e.printStackTrace();
		  }
	}
	
	@Override
	public boolean addBullShit(BullShit bullShit) {
		boolean rvS = false;
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement("INSERT INTO BullShit (Bull, Shit) VALUES(?,?)");
					){
			int index = 1;
			pst.setInt(index++, bullShit.getBull());
			pst.setString(index++, bullShit.getShit());
		
			rvS = pst.executeUpdate() == 1 ? true : false;
		
		} catch (SQLException e) {
			System.out.println("Nem sikerült a hozzáadás");
			e.printStackTrace();
			
		}
		
		return rvS;
	}
	
	@Override
	public List<BullShit> listBullShit() {
		List<BullShit> bullShitList = new ArrayList<BullShit>();
		
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM BullShit");
			
			while (rs.next()) {
				BullShit bS = new BullShit();
				bS.setBull(rs.getInt("Bull"));
				bS.setShit(rs.getString("Shit"));
				
				bullShitList.add(bS);
			}
		}
		
		catch (SQLException e) {
			System.out.println("Nem sikerült a kilistázás");
			e.printStackTrace();
		}
		
		return bullShitList;
	}
	
	public static String getParentDirPath(String fileOrDirPath) {
		boolean endsWithSlash = fileOrDirPath.endsWith(File.separator);
		return fileOrDirPath.substring(0, fileOrDirPath.lastIndexOf(File.separatorChar, 
	            endsWithSlash ? fileOrDirPath.length() - 2 : fileOrDirPath.length() - 1));
	}
}
