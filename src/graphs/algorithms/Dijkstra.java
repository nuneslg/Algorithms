package graphs.algorithms;

import graphs.Graph;
import trees.heaps.Heap;
import trees.heaps.MinHeap;

import java.util.ArrayList;

public class Dijkstra {
    private int [] D;
    private int [] P;
    /**
     * Computes the shortest path from a source vertex to all other vertices in a graph
     * @param g the graph
     * @param s the source vertex
     */
    public Dijkstra(Graph g, int s) {
        // array of distances from the source vertex to all other vertices
        this.D = new int[g.numVertices];
        // array of predecessors of all vertices in the shortest path
        this.P = new int[g.numVertices];
        // array of triples (predecessor, vertex, distance)
        ArrayList<Triple> triples = new ArrayList<>(); // array of triples
        triples.set(1, new Triple(s, s, 0)); // set the triple for the source vertex
        for (int i = 0; i < g.numVertices; i++) {
            D[i] = Integer.MAX_VALUE; // set the distance to infinity
            P[i] = -1; // set the predecessor to -1
            g.setMark(i, 0); // mark all vertices as unvisited
        }
        Heap<Triple> H = new MinHeap<>(triples); // create a min heap of triples
        D[s] = 0; // set the distance from the source vertex to itself to 0
        for (int i = 0; i < g.numVertices - 1; i++) {
            Integer v;
            Integer p;
            do {
                Triple temp = H.removeTop(); // remove the triple with the smallest distance
                p = temp.predecessor(); // predecessor
                v = temp.vertex();
                if (v == null) {
                    return;
                }
            } while (g.getMark(v) == 0); // while the vertex is marked
            g.setMark(v, 1); // mark the vertex as visited
            P[v] = p; // set the predecessor of the vertex
            int w = g.first(v); // get the first vertex adjacent to v
            while (w < g.numVertices) {
                if (g.getMark(w) == 0 && (D[w] > D[v] + g.weight(v, w))) {
                    D[w] = D[v] + g.weight(v, w); // update the distance
                    H.insert(new Triple(v, w, D[w])); // insert the triple into the heap
                }
                w = g.next(v, w); // get the next vertex adjacent to v
            }
        }
    }
    public int[] getDistances() {
        return this.D;
    }
    public int[] getPredecessors() {
        return this.P;
    }
}
