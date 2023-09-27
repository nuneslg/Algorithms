package list;

import node.Node;

public class LinkedList<E> {
    Node<E> header; // header node
    Node<E> tail; // last node
    Node<E> current; // cursor node
    int size; // size of the list

    /**
     * Creates a linked list with a header node
     */
    public LinkedList() {
        this.current = this.header = this.tail = new Node<E>(null); // create header node
        this.size = 0;
    }

    /**
     * Inserts a new element next to the cursor
     * @param l the linked list
     * @param element the element to be inserted
     */
    public void insert(LinkedList<E> l, E element) {
        l.current.next = new Node<E>(element, l.current.next); // insert after current
        if (l.tail == l.current) { // if the element is inserted at the end
            l.tail = l.current.next; // update tail
        }
        l.size++; // update size
    }

    /**
     * Moves the cursor to the start of the list
     * @param l the linked list
     */
    public void moveToStart(LinkedList<E> l) {
        l.current = l.header; // set cursor to the first element
    }

    /**
     * Moves the cursor to the end of the list
     * @param l the linked list
     */
    public void next(LinkedList<E> l) {
        if (l.current != l.tail) { // if the cursor is not at the end
            l.current = l.current.next; // move cursor to the next element
        }
    }

    /**
     * Moves the cursor to the previous element
     * @param l the linked list
     */
    public void prev(LinkedList<E> l) {
        if (l.current == l.header) { // if the cursor is at the start
            return;
        }
        Node<E> temp = l.header; // start at the beginning
        while (temp.next != l.current) { // while the next element is not the cursor
            temp = temp.next; // move to the next element
        }
        l.current = temp; // set the cursor to the previous element
    }

    /**
     * Removes the element next to the cursor
     * @param l the linked list
     * @return the removed element
     */
    public E remove(LinkedList<E> l) {
        if (l.current.next == null) { // if the cursor is at the end
            return null;
        }
        E element = l.current.next.element; // store the element to be removed
        if (l.tail == l.current.next) { // if the element to be removed is at the end
            l.tail = l.current; // update tail
        }
        l.current.next = l.current.next.next; // remove the element
        l.size--; // update size
        return element; // return the removed element
    }
}
