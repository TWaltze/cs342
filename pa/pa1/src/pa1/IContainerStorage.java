package pa1;

import java.util.ArrayList;

public interface IContainerStorage {
	/**
	 * 
	 * @param container The container to be loaded into storage.
	 * 
	 */
	public abstract void addContainer(ShippingContainer container);
	
	/**
	 * 
	 * @param dest The destination to filter containers by
	 * @return An ordered array. The first element is the first container to be shipped.
	 * The last element is the last container to be shipped.
	 * 
	 */
	public abstract ArrayList<ShippingContainer> getContainersToDest(String dest);
}
