package hw2;

public class StringLinkedBagTest {
	public static void main(String args[]){

		StringLinkedBag bag = new StringLinkedBag();

		// add elements to bag
		bag.add("apple");
		bag.add("banana");
		bag.add("peach");
		bag.add("orange");

		System.out.println("Number of items in the bag = " + bag.size());
		System.out.println("Number of apples in the bag = " + bag.countOccurrences("apple"));

		// add contents of one bag to anther bag
		StringLinkedBag anotherBag = new StringLinkedBag();
		anotherBag.add("apple");
		anotherBag.add("watermelon");
		bag.addAll(anotherBag);

		System.out.println();
		System.out.println("Number of items in the bag = " + bag.size());
		System.out.println("Number of apples in the bag = " + bag.countOccurrences("apple"));

		// remove the watermelon
		bag.remove("watermelon");

		// grab a random item from the bag.
		System.out.println();
		System.out.println(bag.grab());

	}
}
