package pa3;

import java.util.ArrayList;
import java.util.Iterator;


public class IntTreeBag implements Cloneable {
    // Invariant of the IntTreeBag class:
    //   1. The elements in the bag are stored in a binary search tree.
    //   2. The instance variable root is a reference to the root of the
    //      binary search tree (or null for an empty tree).
    private BTNode<Integer> root;
    private int count;
    
    public IntTreeBag() {
        root = null;
        count = 0;
    }
    
    /**
    * Insert a new element into this bag.
    * @param <CODE>element</CODE>
    *   the new element that is being inserted
    * <dt><b>Postcondition:</b><dd>
    *   A new copy of the element has been added to this bag.
    * @exception OutOfMemoryError
    *   Indicates insufficient memory a new IntBTNode.
    **/
    public void add(int element) {
        if (root == null) {
            root = new BTNode<Integer>(element);
        } else {
            add(element, root);
        }
        
        count++;
    }
    
    private void add(int element, BTNode<Integer> parent) {
        if (((Comparable<Integer>)element).compareTo(parent.getData()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(new BTNode<Integer>(element));
            } else {
                add(element, parent.getLeft());
            }
        } else if (parent.getRight() == null) {
            parent.setRight(new BTNode<Integer>(element));
        } else {
            add(element, parent.getRight());
        }
    }
    
    /**
    * Add the contents of another bag to this bag.
    * @param <CODE>addend</CODE>
    *   a bag whose contents will be added to this bag
    * <dt><b>Precondition:</b><dd>
    *   The parameter, <CODE>addend</CODE>, is not null.
    * <dt><b>Postcondition:</b><dd>
    *   The elements from <CODE>addend</CODE> have been added to this bag.
    * @exception IllegalArgumentException
    *   Indicates that <CODE>addend</CODE> is null.
    * @exception OutOfMemoryError
    *   Indicates insufficient memory to increase the size of the bag.
    **/
    public void addAll(IntTreeBag append) {
        Iterator<Integer> it = append.iteratorInOrder();
        
        while (it.hasNext()) {
            add(it.next());
        }
    }
    
    /**
    * Generate a copy of this bag.
    * @param - none
    * @return
    *   The return value is a copy of this bag. Subsequent changes to the
    *   copy will not affect the original, nor vice versa. Note that the return
    *   value must be type cast to an <CODE>IntTreeBag</CODE> before it can be used.
    * @exception OutOfMemoryError
    *   Indicates insufficient memory for creating the clone.
    **/
    public Object clone() {
        IntTreeBag copy = new IntTreeBag();
        copy.addAll(this);
        
        return copy;
    }
    
    /**
    * Accessor method to count the number of occurrences of a particular element
    * in this bag.
    * @param <CODE>target</CODE>
    *   the element that needs to be counted
    * @return
    *   the number of times that <CODE>target</CODE> occurs in this bag
    **/
    public int countOccurrences(int target) {
        int amount = 0;
        Integer targetObj = new Integer(target);
        
        Iterator<Integer> it = iteratorInOrder();
        
        while (it.hasNext()) {
            if (targetObj.equals(it.next())) {
                amount++;
            }
        }
        
        return amount;
    }
    
    /**
    * Remove one copy of a specified element from this bag.
    * @param <CODE>target</CODE>
    *   the element to remove from the bag
    * <dt><b>Postcondition:</b><dd>
    *   If <CODE>target</CODE> was found in the bag, then one copy of
    *   <CODE>target</CODE> has been removed and the method returns true.
    *   Otherwise the bag remains unchanged and the method returns false.
    **/
    public boolean remove(int target) {
        return remove(new Integer(target)) != null;
    }
    
    private Integer remove(Integer target) {
        Integer result = null;
        
        if (!isEmpty()) {
            // target is in root
            if (((Comparable)target).equals(root.getData())) {
                result =  root.getData();
                root = replacement(root); // move inorder successor into the root
                count--;
            } else { // the element is not in the root but may be elsewhere: start search
                boolean found = false;
                BTNode<Integer> current;
                
                // root becomes parent
                BTNode<Integer> parent = root;
                
                // search for target in the left subtree of root
                if (((Comparable)target).compareTo(root.getData()) < 0) {
                    current = root.getLeft();
                } else { // search for target in the right subtree of root
                    current = root.getRight();
                }
                
                while (current != null && !found) { // go until search hits a leaf
                    if (target.equals(current.getData())) {
                        found = true;
                        count--;
                        result = current.getData();
                        
                        // if the target is a left child of parent
                        // then replacement becomes parent's left subtree 
                        if (current == parent.getLeft()) {         
                            // point to replacement            
                            parent.setLeft(replacement(current));
                        } else { // or replacement becomes parent's right child
                            parent.setRight(replacement(current));
                        }
                    } else { // make current element into parent and continue search
                        parent = current; // move parent pointer down
                        
                        if (((Comparable)target).compareTo(current.getData()) < 0) {
                            current = current.getLeft();                   
                        } else {
                            current = current.getRight();
                        }
                    }
                }
                
                if (!found) {
                    return null;
                }
            }
        }
        
        return result;
    }

    private BTNode<Integer> replacement(BTNode<Integer> node) {
        BTNode<Integer> result = null;
        
        if ((node.getLeft() == null) && (node.getRight() == null)) {
            result = null;
        } else if ((node.getLeft() != null) && (node.getRight() == null)) {
            result = node.getLeft();
        } else if ((node.getLeft() == null) && (node.getRight() != null)) {
            result = node.getRight();
        } else {
            BTNode<Integer> current = node.getRight();
            BTNode<Integer> parent = node;
            
            while (current.getLeft() != null) {
                parent = current;
                current = current.getLeft();
            }
            
            if (node.getRight() == current) {
                current.setLeft(node.getLeft());
            } else {
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
                current.setLeft(node.getLeft());
            }
            
            result = current;
        }
        
        return result;
    }

    /**
    * Determine the number of elements in this bag.
    * @param - none
    * @return
    *   the number of elements in this bag
    **/
    public long size( ) {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
    * Create a new bag that contains all the elements from two other bags.
    * @param <CODE>b1</CODE>
    *   the first of two bags
    * @param <CODE>b2</CODE>
    *   the second of two bags
    * <dt><b>Precondition:</b><dd>
    *   Neither b1 nor b2 is null.
    * @return
    *   the union of b1 and b2
    * @exception IllegalArgumentException
    *   Indicates that one of the arguments is null.
    * @exception OutOfMemoryError
    *   Indicates insufficient memory for the new bag.
    **/
    public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2) {
        IntTreeBag bag = new IntTreeBag();
        
        bag.addAll(b1);
        bag.addAll(b2);
        
        return bag;
    }

    public Iterator<Integer> iteratorPreOrder() {
        return root.preorderList().listIterator();
    }

    public Iterator<Integer> iteratorInOrder() {
        return root.inorderList().listIterator();
    }

    public Iterator<Integer> iteratorPostOrder() {
        return root.postorderList().listIterator();
    }
}
