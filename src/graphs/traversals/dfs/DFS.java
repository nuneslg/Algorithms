package graphs.traversals.dfs;

import graphs.Graph;
import graphs.traversals.Traversal;

public abstract class DFS extends Traversal {


    protected abstract void preVisit(Graph g, int v);

    protected abstract void postVisit(Graph g, int v);

    /**
     * Traverses a graph using depth-first search
     * @param g the graph
     * @param v the first vertex to be visited
     */
    @Override
    public void traverse(Graph g, int v) {
        preVisit(g, v);
        g.setMark(g,v, 1); // mark the vertex as visited
        int w = g.first(g,v); // get the first adjacent vertex
        while (w < g.numVertices) {
            if (g.getMark(g, w) == 0) { // if the vertex is unvisited
                traverse(g, w); // recursively traverse the vertex
            }
            w = g.next(g, v, w); // get the next adjacent vertex
        }
        postVisit(g, v);
    }
}
