package trees.bst;

public class BSTNode<K extends Comparable<K>, E> implements Comparable<BSTNode<K, E>> {
    public K key;
    public E element;
    public BSTNode<K,E> left; // left child
    public BSTNode<K,E> right; // right child

    public BSTNode(K key, E element) {
        this.key = key;
        this.element = element;
        this.left = this.right = null;
    }

    @Override
    public int compareTo(BSTNode<K,E> another) {
        return this.key.compareTo(another.key);
    }
}
