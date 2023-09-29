package trees.bst;

public abstract class Traversals<K extends Comparable<K>,E> {

    /**
     * Traverses a BST by processing the node, recursively traversing the left subtree and then recursively traversing the right subtree
     * @param rt the root of the subtree
     */
    public void preorder(BSTNode<K,E> rt) {
        if (rt != null) {
            process(rt);
            preorder(rt.left);
            preorder(rt.right);
        }
    }

    /**
     * Traverses a BST by recursively traversing the left subtree, processing the node and then recursively traversing the right subtree
     * @param rt the root of the subtree
     */
    public void inorder(BSTNode<K,E> rt) {
        if (rt != null) {
            inorder(rt.left);
            process(rt);
            inorder(rt.right);
        }
    }

    /**
     * Traverses a BST by recursively traversing the left subtree, recursively traversing the right subtree and then processing the node
     * @param rt the root of the subtree
     */
    public void posorder(BSTNode<K,E> rt) {
        if (rt != null) {
            posorder(rt.left);
            posorder(rt.right);
            process(rt);
        }
    }

    public abstract BSTNode<K,E> process(BSTNode<K,E> rt);
}
