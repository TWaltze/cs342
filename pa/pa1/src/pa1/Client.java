package pa1;

import java.util.Random;

public class Client {
	public static final int NUM_OF_CONTAINERS = 50;
	public static String[] destinations = new String[]{"BOS", "SFO", "LAX", "SJC", "IAD"};

	public static void main(String[] args) {
		System.out.println("**Testing stack implementation**\n");
		testStack();
		
		System.out.println("**Testing queue implementation**\n");
		testQueue();
	}
	
	public static void testStack() {
		IContainerStorage containers = new ContainerStack();
		
		Random rand = new Random();
		for (int i = 0; i < NUM_OF_CONTAINERS; i++) {
			int rNum = rand.nextInt((destinations.length - 0));
			
			containers.addContainer(new ShippingContainer(destinations[rNum] + i));
		}
		
		for (String dest : destinations) {
			System.out.println("Containers going to " + dest);
			System.out.println(containers.getContainersToDest(dest));
			System.out.println("\n");
		}
	}
	
	public static void testQueue() {
		IContainerStorage containers = new ContainerQueue();
		
		Random rand = new Random();
		for (int i = 0; i < NUM_OF_CONTAINERS; i++) {
			int rNum = rand.nextInt((destinations.length - 0));
			
			containers.addContainer(new ShippingContainer(destinations[rNum] + i));
		}
		
		for (String dest : destinations) {
			System.out.println("Containers going to " + dest);
			System.out.println(containers.getContainersToDest(dest));
			System.out.println("\n");
		}
	}
}
