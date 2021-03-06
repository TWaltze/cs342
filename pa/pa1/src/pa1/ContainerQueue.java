package pa1;

import java.util.*;

public class ContainerQueue implements IContainerStorage {
	private Map<String, Queue<ShippingContainer>> containers = new HashMap<String, Queue<ShippingContainer>>();

	@Override
	public void addContainer(ShippingContainer container) {
		// Get the destination of a container
		String dest = container.getDestination();
		
		// Add a new destination if it doesn't already exist
		if (!containers.containsKey(dest)) {
			containers.put(dest, new LinkedList<ShippingContainer>());
		}

		// Add container to its destination
		containers.get(dest).add(container);
	}

	@Override
	public ArrayList<ShippingContainer> getContainersToDest(String dest) {
		ArrayList<ShippingContainer> list = new ArrayList<ShippingContainer>(containers.get(dest));

		return list;
	}

}
