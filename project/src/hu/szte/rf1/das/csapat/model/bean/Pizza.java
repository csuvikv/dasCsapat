package hu.szte.rf1.das.csapat.model.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Pizza {
	private int id;
	private String name;
	private int size;
	private int cost;
	private List<String> ingredients;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredientToList(String ingredient) {
		this.ingredients.add(ingredient);
	}
	
	public void removeIngredientFromList(String ingredient) {
		for (Iterator<String> iter = ingredients.listIterator(); iter.hasNext(); ) {
	    	String temp = iter.next();
	    	if (ingredient.equals(temp)) {
	        	iter.remove();
	    	}
		}
	}
	
	public String saveIngredientsToDatabase() {
		String buffer = "";
		
		for(String temp : this.ingredients) {
			buffer += temp + ","; 
		}
		
		return buffer;
	}
	
	public void readIngredientsFromDataBase(String ingredients) {
		String[] result = ingredients.split(",");
		this.ingredients = new ArrayList<>(Arrays.asList(result));
	}
	
	public String ingredientsToString() {
		String buffer;
		buffer = "Ingredients: ";
		
		for(String temp : this.ingredients) {
			buffer += ", " + temp; 
		}
		
		return buffer;
	}
	
	@Override
	public String toString() {
		return "Pizza: [id: " + this.id +
				"       name: " + this.name +
				"       size: " + this.size + "cm" +
				"       cost: " + this.cost + "ft" +
				" " + ingredientsToString() + "]";
	}
}
