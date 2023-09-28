package trees.bst;

public class BST<K extends Comparable<K>,E>{
    BSTNode<K,E> root; // root of the tree
    int size; // number of nodes in the tree

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Finds the element int the tree associated with the key
     * @param bst the tree
     * @param k the key
     * @return the element associated with the key
     */
    public E find(BST<K,E> bst, K k) {
        return findHelp(bst.root, k);
    }

    /**
     * Helper method for find
     *
     * @param rt the node whose subtree is to be searched
     * @param k  the key to be searched
     * @return the element associated with the key
     */
    public E findHelp(BSTNode<K,E> rt, K k) {
        if (rt == null) {
            return null;
        }
        if (rt.key.compareTo(k) > 0) { // if the key is less than the root's subtree key
            return findHelp(rt.left, k); // recursively search the left subtree
        } else if (rt.key.equals(k)) { // if the key is equal to the root's subtree key
            return (rt.element); // return the element associated with the key
        } else {
            return findHelp(rt.right, k); // recursively search the right subtree
        }
    }

    /**
     * Inserts a new node into the tree
     * @param bst the tree
     * @param k the key
     * @param e the element
     */
    public void insert(BST<K,E> bst, K k, E e) {
        bst.root = insertHelp(bst.root, k, e);
        bst.size++;
    }

    /**
     * Helper method for insert
     * @param rt the root of the subtree
     * @param k the key
     * @param e the element
     * @return the root of the subtree
     */
    public BSTNode<K, E> insertHelp(BSTNode<K,E> rt, K k, E e) {
        if (rt == null) { // if the subtree is empty
            return new BSTNode<>(k, e); // create a new node
        }
        if (rt.key.compareTo(k) > 0) { // if the key is less than the root's subtree key
            rt.left = insertHelp(rt.left, k, e); // recursively insert into the left subtree
        } else { // if the key is greater than or equal to the root's subtree key
            rt.right = insertHelp(rt.right, k, e); // recursively insert into the right subtree
        }
        return rt;
    }

    /**
     * Removes the node associated with the key
     * @param bst the tree
     * @param k the key
     * @return the element associated with the key
     */
    public E remove(BST<K,E> bst, K k) {
        E temp = findHelp(bst.root, k);
        if(temp != null) {
            bst.root = removeHelp(bst.root, k);
            bst.size--;
        }
        return temp;
    }

    /**
     * Helper method for remove
     * @param rt the root of the subtree
     * @param k the key
     * @return the root of the subtree
     */
    public BSTNode<K,E> removeHelp(BSTNode<K,E> rt, K k) {
        if(rt == null) {return null;}
        // recursively search for the key
        if(rt.key.compareTo(k) > 0) {
            rt.left = removeHelp(rt.left, k);
        } else if(rt.key.compareTo(k) < 0) {
            rt.right = removeHelp(rt.right, k);
        } else { // if the key is found
            if(rt.left == null) { // if the node has no left child
                return rt.right;
            } else if(rt.right == null) { // if the node has no right child
                return rt.left;
            } else { // if the node has two children
                BSTNode<K,E> temp = getMin(rt.right); // get the minimum node in the right subtree
                rt.element = temp.element; // copy the element
                rt.key = temp.key; // copy the key
                rt.right = deleteMin(rt.right); // delete the minimum node in the right subtree
            }
        }
        return rt;
    }

    /**
     * Gets the minimum node in the subtree
     * @param rt the root of the subtree
     * @return the minimum node
     */
    public BSTNode<K,E> getMin(BSTNode<K,E> rt) {
        if(rt.left == null) {
            return rt;
        }
        return getMin(rt.left);
    }

    /**
     * Deletes the minimum node in the subtree
     * @param rt the root of the subtree
     * @return the root of the subtree
     */
    public BSTNode<K,E> deleteMin(BSTNode<K,E> rt) {
        if(rt.left == null) {
            return rt.right;
        }
        rt.left = deleteMin(rt.left);
        return rt;
    }
}
