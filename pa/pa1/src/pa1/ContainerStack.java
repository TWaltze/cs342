package pa1;

import java.util.*;

public class ContainerStack implements IContainerStorage {
	private Map<String, Stack<ShippingContainer>> containers = new HashMap<String, Stack<ShippingContainer>>();

	@Override
	public void addContainer(ShippingContainer container) {
		// Get the destination of a container
		String dest = container.getDestination();
		
		// Add a new destination if it doesn't already exist
		if (!containers.containsKey(dest)) {
			containers.put(dest, new Stack<ShippingContainer>());
		}

		// Add container to its destination
		containers.get(dest).push(container);
	}

	@Override
	public ArrayList<ShippingContainer> getContainersToDest(String dest) {
		// Create a copy so as to not edit the original stack
		Stack<ShippingContainer> tmp = new Stack<ShippingContainer>();
		tmp.addAll(containers.get(dest));
		
		// Create basic list to hold all containers
		ArrayList<ShippingContainer> list = new ArrayList<ShippingContainer>();
		
		// Add top ShippingContainer to the list
		while (!tmp.empty()) {
			list.add(tmp.pop());
		}
		
		return list;
	}

}
