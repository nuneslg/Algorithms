package graphs.traversals;

import graphs.Graph;

public abstract class DFS extends Traversal implements PreVisit, PosVisit {


    protected abstract void preVisit(Graph g, int v);

    protected abstract void postVisit(Graph g, int v);

    /**
     * Traverses a graph using depth-first search
     * @param g the graph
     * @param v the vertex
     */
    @Override
    public void traverse(Graph g, int v) {
        preVisit(g, v);
        g.setMark(g,v, 1);
        int w = g.first(g,v);
        while (w < g.getNumVertices(g)) {
            if (g.getMark(g, w) == 0) {
                traverse(g, w);
            }
            w = g.next(g, v, w);
        }
        postVisit(g, v);
    }
}
