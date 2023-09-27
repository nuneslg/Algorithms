package graphs;

@FunctionalInterface
public interface PreVisit {
    /**
     * Visits a vertex before visiting its adjacent vertices
     * @param g the graph
     * @param v the vertex
     */
    void visit(Graph g, int v);
}
