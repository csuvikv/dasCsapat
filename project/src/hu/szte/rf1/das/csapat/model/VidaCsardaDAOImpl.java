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

import hu.szte.rf1.das.csapat.model.bean.Pizza;

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
	public boolean addPizza(Pizza pizza) {
		boolean rvS = false;
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement("INSERT INTO Pizza(name, cost, size, ingredients) VALUES(?,?,?,?)");
					){
			int index = 1;
			
			pst.setString(index++, pizza.getName());
			pst.setInt(index++, pizza.getCost());
			pst.setInt(index++, pizza.getSize());
			pst.setString(index++, pizza.saveIngredientsToDatabase());			
			
			rvS = pst.executeUpdate() == 1 ? true : false;
		
		} catch (SQLException e) {
			System.out.println("Nem sikerült a hozzáadás");
			e.printStackTrace();
			
		}
		
		return rvS;
	}
	
	@Override
	public List<Pizza> listPizza() {
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE);
				Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM Pizza");
			
			while (rs.next()) {
				Pizza p = new Pizza();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSize(rs.getInt("size"));
				p.setCost(rs.getInt("cost"));
				p.readIngredientsFromDataBase(rs.getString("ingredients"));
				
				pizzaList.add(p);
			}
		}
		
		catch (SQLException e) {
			System.out.println("Nem sikerült a kilistázás");
			e.printStackTrace();
		}
		
		return pizzaList;
	}
	
	public static String getParentDirPath(String fileOrDirPath) {
		boolean endsWithSlash = fileOrDirPath.endsWith(File.separator);
		return fileOrDirPath.substring(0, fileOrDirPath.lastIndexOf(File.separatorChar, 
	            endsWithSlash ? fileOrDirPath.length() - 2 : fileOrDirPath.length() - 1));
	}
}
