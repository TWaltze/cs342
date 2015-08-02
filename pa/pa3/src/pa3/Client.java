package pa3;

import java.util.Iterator;

public class Client {

	public static void main(String[] args) {
		IntTreeBag bag = new IntTreeBag();
		
		// Test addition
		bag.add(34);
		bag.add(45);
		bag.add(3);
		bag.add(87);
		bag.add(65);
		bag.add(32);
		bag.add(1);
		bag.add(12);
		bag.add(17);
		
		// Test removal
		bag.remove(34);
		bag.remove(3);
		bag.remove(17);
		
		// Test final bag state
		Iterator<Integer> it = bag.iteratorInOrder();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
