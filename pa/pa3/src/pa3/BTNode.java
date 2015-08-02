package pa3;

import java.util.ArrayList;

public class BTNode<E> {
    // Invariant of the BTNode<E> class:
    //   1. Each node has one reference to an E Object, stored in the instance
    //      variable data.
    //   2. The instance variables left and right are references to the node's
    //      left and right children.
    private E data;
    private BTNode<E> left, right;
    
    public BTNode(E initialData) {
    	this(initialData, null, null);
    }
    
    public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight) {
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }
    
    public E getData( ) {
    	return data;
    }
    
    public BTNode<E> getLeft( ) {
        return left;
    }
    
    public E getLeftmostData( ) {
        if (left == null) {
            return data;
        } else {
            return left.getLeftmostData();
        }
    }
    
    public BTNode<E> getRight( ) {
        return right;
    }
    
    public E getRightmostData( ) {
        if (right == null) {
            return data;
        } else {
            return right.getRightmostData();
        }
    }
    
    public ArrayList<E> inorderList() {
        ArrayList<E> result = new ArrayList<E>();
        
        inorderList(result);
        
        return result;
    }
    
    private void inorderList(ArrayList<E> list) {
        if (left != null) {
            left.inorderList(list);
        }
        
        list.add(data);
        
        if (right != null) {
            right.inorderList(list);
        }
    }
    
    public ArrayList<E> preorderList() {
        ArrayList<E> result = new ArrayList<E>();
        
        preorderList(result);
        
        return result;
    }
    
    private void preorderList(ArrayList<E> list) {
        list.add(data);
        
        if (left != null) {
            left.preorderList(list);
        }
        
        if (right != null) {
            right.preorderList(list);
        }
    }
    
    public ArrayList<E> postorderList() {
        ArrayList<E> result = new ArrayList<E>();
        
        postorderList(result);
        
        return result;
    }
    
    private void postorderList(ArrayList<E> list) {
        if (left != null) {
            left.postorderList(list);
        }
        
        if (right != null) {
            right.postorderList(list);
        }
        
        list.add(data);
    }
    
    public boolean isLeaf() {
        return right == null && left == null;
    }
    
    public BTNode<E> removeLeftmost() {
    	if (left.getLeft() == null) {
            left = null;
        } else {
            left.removeLeftmost();
        }
    	
    	return this;
    }
    
    public BTNode<E> removeRightmost() {
    	if (right.getRight() == null) {
            right = null;
        } else {
            right.removeRightmost();
        }
    	
    	return this;
    }
    
    public void setData(E newData) {
        data = newData;
    }
    
    public void setLeft(BTNode<E> newLeft) {
        left = newLeft;
    }
    
    public void setRight(BTNode<E> newRight) {
        right = newRight;
    }
    
    public static <E> BTNode<E> treeCopy(BTNode<E> source) {
    	BTNode<E> root = new BTNode<E>(source.getData(), treeCopy(source.getLeft()), treeCopy(source.getRight()));

        return root;
    }
    
    public static <E> long treeSize(BTNode<E> root) {
        return 1 + treeSize(root.getLeft()) + treeSize(root.getRight());
    }
}
