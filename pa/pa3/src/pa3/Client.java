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
		
		// Test final bag state
		Iterator<Integer> in = bag.iteratorInOrder();
		System.out.println("Inorder");
		while (in.hasNext()) {
			System.out.print(in.next() + " ");
		}
		System.out.println("\n");
		
		Iterator<Integer> pre = bag.iteratorPreOrder();
		System.out.println("Preorder");
		while (pre.hasNext()) {
			System.out.print(pre.next() + " ");
		}
		System.out.println("\n");
		
		Iterator<Integer> post = bag.iteratorPostOrder();
		System.out.println("Postorder");
		while (post.hasNext()) {
			System.out.print(post.next() + " ");
		}
		System.out.println("\n");
		
		// Test removal
		bag.remove(34);
		bag.remove(3);
		bag.remove(17);
		
		Iterator<Integer> rm = bag.iteratorInOrder();
		System.out.println("Inorder after removal of 34, 3, 17");
		while (rm.hasNext()) {
			System.out.print(rm.next() + " ");
		}
		System.out.println("\n");
		
		// Test occurrence count
		bag.add(12);
		Iterator<Integer> add = bag.iteratorInOrder();
		System.out.println("Inorder after addition of 12");
		while (add.hasNext()) {
			System.out.print(add.next() + " ");
		}
		System.out.println("\n");
		
		System.out.println("Number of occurrences of 12: " + bag.countOccurrences(12));
	}

}
