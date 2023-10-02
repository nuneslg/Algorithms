package trees.heaps;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> extends Heap<T>{

    public MinHeap(ArrayList<T> array) {
        super(array);
    }

    @Override
    public void Heapify(ArrayList<T> H, int n) {
// for each internal node in the tree
        for (int i = n/2; i > 0; i--) {
            int k = i; // current position of the i-th internal node
            T v = H.get(k); // value of the i-th internal node
            boolean heap = false; // boolean indicating whether the heap property is satisfied
            // finding the proper place for the i-th internal node
            while (!heap && 2*k <= n) { // while the heap property is not satisfied and the node is an inner node
                int j = 2*k; // position of the first child
                if (j < n) { // if the node has two children
                    if (H.get(j).compareTo(H.get(j + 1)) > 0) {
                        j++; // j is the index of the smaller child
                    }
                }
                if (v.compareTo(H.get(j)) <= 0) { //if the node is smaller than its children
                    heap = true; // the heap property is satisfied
                } else {
                    H.set(k, H.get(j)); // move the smaller child up
                    k = j; // update the index of the node
                }
            }
            H.set(k, v); // insert the node
        }
    }
}
