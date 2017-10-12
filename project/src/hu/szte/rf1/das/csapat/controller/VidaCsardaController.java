package hu.szte.rf1.das.csapat.controller;

import java.util.List;

import hu.szte.rf1.das.csapat.model.VidaCsardaDAO;
import hu.szte.rf1.das.csapat.model.VidaCsardaDAOImpl;
import hu.szte.rf1.das.csapat.model.bean.Pizza;

public class VidaCsardaController {
	
	private VidaCsardaDAO db = new VidaCsardaDAOImpl();

	public boolean addPizza(Pizza pizza) {		
		return db.addPizza(pizza);
	}
	
	public List<Pizza> listPizza() {
		return db.listPizza();
	}

}
