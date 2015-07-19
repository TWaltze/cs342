Tyler Waltze

7/19/15

MET CS 342

Homework 3

Assuming the following code exists:

    public class Node<E> {
        public E data;
        public Node<E> link;
    }

    public class LinkedStack<E> implements Cloneable {
        private Node<E> top;

        // other methods here
    }

1. Write the push method for the LinkedStack<E> class. (25 points)

        public void push(Node item) {
        }

Assuming the following code exists:

    public class Node<E> {
        public E data;
        public Node<E> link;
    }

    public class LinkedQueue<E> implements Cloneable {
        private int manyNodes;
        private Node<E> front;
        private Node<E> rear;

        // other methods here
    }

2. Write the add method for the LinkedQueue<E> class (25 points)

        public void push(Node item) {
        }

3. When writing a data structure, the design goal should be to minimize the work and error conditions for the client. Having said that, what mechanisms should/do stacks and queues provide to help clients not run into error conditions? Explain your answer. (25 points)

4. If I wanted to loop through different kinds of collections in a common way what mechanism should be available for client use? (25 points)
