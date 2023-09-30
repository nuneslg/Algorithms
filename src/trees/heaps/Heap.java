package trees.heaps;

public class Heap {
    public int size;
    public int[] heap;

    public Heap(int[] heap) {
        this.heap = heap;
        this.size = heap.length;
    }

    /**
     * Heapifies the array
     * @param H the array
     * @param n the size of the array
     */
    public void Heapify(int[] H, int n) {
        // for each internal node in the tree
        for (int i = n/2; i > 0; i--) {
            int k = i; // current position of the i-th internal node
            int v = H[k]; // value of the i-th internal node
            boolean heap = false; // boolean indicating whether the heap property is satisfied
            // finding the proper place for the i-th internal node
            while (!heap && 2*k <= n) { // while the heap property is not satisfied and the node is an inner node
                int j = 2*k; // position of the first child
                if (j < n) { // if the node has two children
                    if (H[j] < H[j+1]) {
                        j++; // j is the index of the larger child
                    }
                }
                if (v >= H[j]) { //if the node is larger than its children
                    heap = true; // the heap property is satisfied
                } else {
                    H[k] = H[j]; // move the larger child up
                    k = j; // update the index of the node
                }
            }
            H[k] = v; // insert the node
        }
    }

}
