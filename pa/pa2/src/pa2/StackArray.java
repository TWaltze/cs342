package pa2;

public class StackArray<Type> {
    private Type[] items;	// Items being stored
    private int total;		// Counter of actual items in array

    public StackArray() {
        items = (Type[]) new Object[2];
    }

    private void resize(int size) {
        Type[] tmp = (Type[]) new Object[size];
        
        // Efficient/easy array copy
        System.arraycopy(items, 0, tmp, 0, total);
        
        items = tmp;
    }

    public StackArray<Type> push(Type item) {
    	// Increase size of array if it's already full
        if (items.length == total) {
        	resize(items.length * 2);
        }
        
        // Add item to top of array and increase total counter
        items[total] = item;
        total++;
        
        // Allow chaining
        return this;
    }

    public Type pop() {
    	// Throw an error if there isn't an item to remove
        if (total == 0) {
        	throw new java.util.NoSuchElementException();
        }
        
        // Get the top item and decrement the total counter
        Type item = items[total - 1];
        total--;
        
        // Remove the item from the array
        items[total] = null;

        return item;
    }

    public String toString() {
        return java.util.Arrays.toString(items);
    }

}