package hu.szte.rf1.das.csapat.model.bean;

public class Customer extends User {

	private String email;
	private Address address;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer: [id: " + getId() + 
				"          name:" + getName() +
				"          email:" + this.email + 
				" " + address.toString() + "]";
	}
}
