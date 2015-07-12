package pa1;

public class ShippingContainer {

	private String id;
	
	public ShippingContainer(String newId){
		this.id = newId;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDestination() {
		return this.id.substring(0, 3);
	}
	
	public String toString() {
		return id;
	}
}