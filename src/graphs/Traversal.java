package graphs;

import graphs.Graph;

public abstract class Traversal {
    public abstract void traverse(Graph g, int v);

    /**
     * Traverses a graph
     * @param g the graph
     */
    public void graphTraverse(Graph g) {
        for (int v = 0; v < g.getNumVertices(g); v++) {
            g.setMark(g, v, 0); // mark all vertices as unvisited
        }
        for (int v = 0; v < g.getNumVertices(g); v++) {
            if (g.getMark(g, v) == 0) { // guaranties that all vertices are visited in case of a disconnected graph
                traverse(g, v);
            }
        }
    }
}
