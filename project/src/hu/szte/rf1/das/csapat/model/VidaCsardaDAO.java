package hu.szte.rf1.das.csapat.model;

import java.util.List;

import hu.szte.rf1.das.csapat.model.bean.Pizza;

public interface VidaCsardaDAO {
	
	boolean addPizza(Pizza pizza);
	List<Pizza> listPizza();
	
}
