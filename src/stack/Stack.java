package stack;

import node.Node;

/**
 * A stack is a data structure that stores elements in a last-in, first-out (LIFO) fashion
 * The stack does not have a header node
 * @param <E> the type of elements in the stack
 */
public class Stack<E> {
    public Node<E>  top; // reference to the first element
    public int size; // size of the stack

    /**
     * Creates an empty stack
     */
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Insert an element at the top of the stack
     * @param s the stack
     * @param element the element to be inserted
     */
    public void push(Stack<E> s, E element) {
        s.top = new Node<>(element, s.top); // insert at the top
        s.size++; // update size
    }

    /**
     * Removes the element at the top of the stack
     * @param s the stack
     * @return the element that was removed
     */
    public E pop(Stack<E> s) {
        if (s.top == null) { // if the stack is empty
            System.out.println("The stack is empty.");
            return null;
        }
        E item = s.top.element; // store the element
        s.top = s.top.next; // move the top to the next element
        s.size--; // update size
        return item; // return the element
    }
}
