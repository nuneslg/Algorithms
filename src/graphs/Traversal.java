package graphs;

public abstract class Traversal {

    /**
     * Executes the chosen traversal algorithm
     * @param g the graph
     * @param v the vertex
     */
    public abstract void traverse(Graph g, int v);

    /**
     * Traverses a graph ensuring that all vertices are visited in case of a disconnected graph and calls the chosen traversal algorithm
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
