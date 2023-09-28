package graphs.traversals.dfs;

import graphs.Graph;
import graphs.traversals.Traversal;

public abstract class DFS extends Traversal {

    /**
     * Traverses a graph using depth-first search
     *
     * @param g     the graph
     * @param start the first vertex to be visited
     */
    @Override
    public void traverse(Graph g, int start) {
        preVisit(g, start);
        g.setMark(g, start, 1); // mark the vertex as visited
        int w = g.first(g, start); // get the first adjacent vertex
        while (w < g.numVertices) {
            if (g.getMark(g, w) == 0) { // if the vertex is unvisited
                traverse(g, w); // recursively traverse the vertex
            }
            w = g.next(g, start, w); // get the next adjacent vertex
        }
        postVisit(g, start);
    }

    protected abstract void preVisit(Graph g, int v);

    protected abstract void postVisit(Graph g, int v);

}
