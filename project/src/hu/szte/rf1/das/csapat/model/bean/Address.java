package hu.szte.rf1.das.csapat.model.bean;

public class Address {
	private String city;
	private String street;
	private int zipCode;
	private String houseNumber;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	@Override
	public String toString() {
		return "Address: [City: " + this.city +
				"         Street: " + this.street +
				"         Zip-Code: " + this.zipCode +
				"         House Number: " + this.houseNumber + "]";
	}
	
}
