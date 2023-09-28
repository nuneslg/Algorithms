package graphs.traversals;

import graphs.Graph;

public abstract class Traversal {

    /**
     * Executes the chosen traversal algorithm
     * @param g the graph
     * @param v the vertex
     */
    protected abstract void traverse(Graph g, int v);

    /**
     * Traverses a graph ensuring that all vertices are visited in case of a disconnected graph and calls the chosen traversal algorithm
     * @param g the graph
     * @param vertex the vertex
     */
    public void graphTraverse(Graph g,  int vertex) {
        for (int v = 0; v < g.numVertices; v++) {
            g.setMark(g, v, 0); // mark all vertices as unvisited
        }
        for (int v = 0; v < g.numVertices; v++) {
            if (g.getMark(g, v) == 0) { // guaranties that all vertices are visited in case of a disconnected graph
                traverse(g, vertex);
            }
        }
    }
}
