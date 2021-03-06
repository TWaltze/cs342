package pa2;

public class StackArray<Type> {
    private Type[] items;	// Items being stored
    private int total;		// Counter of actual items in array

    public StackArray() {
        this(2);
    }
    
    public StackArray(int size) {
    	items = (Type[]) new Object[size];
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
    
    public Type peek() {
    	// Throw an error if there isn't an item to remove
        if (total == 0) {
        	throw new java.util.NoSuchElementException();
        }
        
    	return items[total - 1];
    }
    
    public Boolean isEmpty() {
    	return total == 0;
    }
    
    public void clear() {
    	// Reset properties to their initial values
    	items = (Type[]) new Object[2];
    	total = 0;
    }
    
    public int size() {
    	return total;
    }
    
    public Type get(int position) {
    	return items[position];
    }

    public String toString() {
        return java.util.Arrays.toString(items);
    }

}