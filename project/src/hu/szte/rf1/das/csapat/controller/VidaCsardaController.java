package hu.szte.rf1.das.csapat.controller;

import java.util.List;

import hu.szte.rf1.das.csapat.model.VidaCsardaDAO;
import hu.szte.rf1.das.csapat.model.VidaCsardaDAOImpl;
import hu.szte.rf1.das.csapat.model.bean.BullShit;

public class VidaCsardaController {
	
	private VidaCsardaDAO db = new VidaCsardaDAOImpl();

	public boolean addBullShit(BullShit bullShit) {		
		return db.addBullShit(bullShit);
	}
	
	public List<BullShit> listBullShit() {
		return db.listBullShit();
	}

}
