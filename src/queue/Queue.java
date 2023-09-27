package queue;

import node.Node;

/**
 * A queue is a data structure that stores elements in a first-in, first-out (FIFO) order.
 * The queue does have a header node
 * @param <E>
 */
public class Queue<E> {
    public Node<E> front; // the reference to the header node
    public Node<E> rear; //  the reference to the last node
    public int size; // the size of the queue

    /**
     * Creates an empty queue with a header node
     */
    public Queue() {
        this.front = this.rear = new Node<>(null); // create header node
        this.size = 0;
    }

    /**
     * Inserts a new element at the queue
     * @param q the queue
     * @param element the element to be inserted
     */
    public void enqueue(Queue<E> q, E element) {
        q.rear.next = new Node<>(element, null); // insert at the end
        q.rear = q.rear.next; // update rear
        q.size++;
    }

    /**
     * Removes the first element from the queue
     * @param q the queue
     * @return the element removed
     */
    public E dequeue(Queue<E> q) {
        if (q.size == 0) { // if the queue is empty
            System.out.println("The queue is empty");
            return null;
        }
        E element = q.front.next.element; // get the element
        q.front.next = q.front.next.next; // remove the element
        if (q.front.next == null) { // if the queue is empty
            q.rear = q.front; // update rear
        }
        q.size--;
        return element;
    }
}

