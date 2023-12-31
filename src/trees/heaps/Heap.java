package trees.heaps;

import java.util.ArrayList;

public abstract class Heap<T> {
    public int size; // size of the heap
    public ArrayList<T> heap; // array representing the heap


    public Heap(ArrayList<T> array) {
        this.heap = new ArrayList<>();
        this.heap.add(null); // the first element of the array is null
        this.heap.addAll(array);
        this.size = array.size();
        Heapify(this.heap, this.size);
    }

    /**
     * Heapifies the array
     *
     * @param H the array
     * @param n the size of the array
     */
    public abstract void Heapify(ArrayList<T> H, int n);


    public void insert(T element) {
        this.heap.add(element);
        this.size++;
        Heapify(this.heap, this.size);
    }

    public T removeTop() {
        T top = this.heap.get(1);
        this.heap.remove(1);
        this.size--;
        Heapify(this.heap, this.size);
        return top;
    }
}


