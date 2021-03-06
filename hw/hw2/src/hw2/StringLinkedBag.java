package hw2;

public class StringLinkedBag implements Cloneable {
	private StringNode head;
	private int count;
	
	// LinkedList constructor
	public StringLinkedBag() {
		head = null;
		count = 0;
	}
	
	// Appends the specified element to the end of this list.
	public void add(String data) {
		StringNode temp = new StringNode(data);
		
		if (head == null) {
			// If the list is empty, make it the head
			head = temp;
		} else {
			StringNode current = head;
			
			// starting at the head node, crawl to the end of the list
			while(current.getNext() != null) {
				current = current.getNext();
			}
			
			// Set last node's "next" reference to our new node
			current.setNext(temp);
		}
		
		// increment the element count
		count++;
	}
	
	public void addAll(StringLinkedBag bag) {
		if (head == null) {
			head = bag.grab();
		} else {
			StringNode last = head;
			
			while (last.getNext() != null) {
				last = last.getNext();
			}
			
			last.setNext(bag.grab());
			count += bag.size();
		}
	}
	
	public void getLast() {
		StringNode last = head;
		
		while (last.getNext() != null) {
			last = last.getNext();
		}
	}
	
	// Remove the element at the given position.
	public boolean remove(String key) {
		StringNode current = head;
		StringNode prev = null;
		
		while (current.getNext() != null && current.getData() != key) {
			prev = current;
			current = current.getNext();
		}
		
		prev.setNext(current.getNext());
		
		// Decrease element count
		count--;
		
		return true;
	}
	
	// Get the first item of the list
	public StringNode grab() {
		return head;
	}
	
	public int countOccurrences(String key) {
		StringNode current = head;
		int occurences = 0;
		
		while (current.getNext() != null) {
			if (current.getData() == key) {
				occurences++;
			}
			current = current.getNext();
		}
		
		return occurences;
	}
	
	// Get the number of elements in list.
	public int size() {
		return count;
	}
}
