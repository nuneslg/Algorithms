package graphs.traversals.bfs;

import graphs.Graph;
import graphs.traversals.Traversal;
import queue.Queue;

public abstract class BFS extends Traversal {
    public Queue<Integer> Q; // queue of vertices to visit
    @Override
    public void traverse(Graph g, int start) {
        Q = new Queue<>();
        Q.enqueue(Q, start);
        g.setMark(g, start, 1); // mark the vertex as visited
        while (Q.size > 0) {
            int v = Q.dequeue(Q); // get the next vertex to visit
            preVisit(g, v);
            int w = g.first(g, v); // get the first adjacent vertex
            while (w < g.numVertices) {
                if (g.getMark(g, w) == 0) { // if the vertex is unvisited
                    g.setMark(g, w, 1); // mark the vertex as visited
                    Q.enqueue(Q, w); // enqueue the vertex
                }
                w = g.next(g, v, w); // get the next adjacent vertex
            }
            postVisit(g, v);
        }
    }
    protected abstract void preVisit(Graph g, int v);
    protected abstract void postVisit(Graph g, int v);
}

