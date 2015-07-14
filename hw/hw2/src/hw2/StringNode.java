package hw2;

public class StringNode {
	private StringNode next;	// Next node in list
	private String data;		// Stored data
	
	public StringNode(String data) {
		this.data = data;
		this.next = null;
	}
	
	public StringNode(String data, StringNode next) {
		this.data = data;
		this.next = next;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public StringNode getNext() {
		return next;
	}
	
	public void setNext(StringNode next) {
		this.next = next;
	}
	
	public String toString() {
		return this.data;
	}
}
