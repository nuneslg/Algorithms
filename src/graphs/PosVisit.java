package graphs;

@FunctionalInterface
public interface PosVisit {
    /**
     * Visits a vertex after visiting its adjacent vertices
     * @param g the graph
     * @param v the vertex
     */
    void visit(Graph g, int v);
}
