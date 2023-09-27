package node;

public class Node<E> {
    public E element;
    public Node<E> next;

    /**
     * Creates a node of a generic type
     * @param element the element to be stored in the node
     * @param next the node that it points to
     */
    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    /**
     * Creates a node of a generic type. Used for the header node
     * @param next the next node in the list
     */
    public Node(Node<E> next) {
        this.next = next;
    }
}
