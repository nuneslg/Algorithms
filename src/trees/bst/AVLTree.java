package trees.bst;

public class AVLTree<K extends Comparable<K>, E> extends BST<K, E> {

    /**
     * Inserts a new node into the tree
     * @param rt the root of the subtree
     * @param k the key
     * @param e the element
     * @return the root of the subtree
     */
    public BSTNode<K,E> insertHelp(BSTNode<K, E> rt, K k, E e) {
        // insertHelp from normal BST
        super.insertHelp(rt, k, e);
        // update the height of the node, get the balance of the node and perform rotations if necessary
        rt.height = Math.max(h(rt.left), h(rt.right)) + 1;
        int balance = getBalance(rt);
        if (balance < -1 && k.compareTo(rt.right.key) >= 0) {
            return leftRotate(rt);
        }
        if (balance > 1 && k.compareTo(rt.left.key) < 0) {
            return rightRotate(rt);
        }
        if (balance > 1 && k.compareTo(rt.left.key) >= 0) {
            rt.left = leftRotate(rt.left);
            return rightRotate(rt);
        }
        if (balance < -1 && k.compareTo(rt.right.key) < 0) {
            rt.right = rightRotate(rt.right);
            return leftRotate(rt);
        }
        return rt;
    }

    /**
     * Returns the balance of the node
     * @param rt the node
     * @return the balance of the node
     */
    int getBalance(BSTNode<K,E> rt) {
        if (rt == null) {
            return 0;
        }
        return h(rt.left) - h(rt.right);
    }

    /**
     * Returns the height of the node
     * @param rt the node
     * @return the height of the node
     */
    int h(BSTNode<K,E> rt) {
        if (rt == null) {
            return -1;
        }
        return rt.height;
    }

    /**
     * Performs a right rotation on the root
     * @param rt the root
     * @return the new root
     */
    BSTNode<K,E> rightRotate(BSTNode<K,E> rt) {
        BSTNode<K,E> l = rt.left; // left child of the root
        BSTNode<K,E> lr = l.right; // right child of the left child of the root
        l.right = rt; // make the root the right child of the left child of the root
        rt.left = lr; // make the right child of the left child of the root the left child of the root
        rt.height = Math.max(h(rt.left), h(rt.right)) + 1;
        l.height = Math.max(h(l.left), h(l.right)) + 1;
        return l;
    }

    /**
     * Performs a left rotation on the root
     * @param rt the root
     * @return the new root
     */
    BSTNode<K,E> leftRotate(BSTNode<K,E> rt) {
        BSTNode<K,E> r = rt.right; // right child of the root
        BSTNode<K,E> rl = r.left; // left child of the right child of the root
        r.left = rt; // make the root the left child of the right child of the root
        rt.right = rl; // make the left child of the right child of the root the right child of the root
        rt.height = Math.max(h(rt.left), h(rt.right)) + 1;
        r.height = Math.max(h(r.left), h(r.right)) + 1;
        return r;
    }
}
