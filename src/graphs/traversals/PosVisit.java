package graphs.traversals;

import graphs.Graph;

/**
 * Processes a vertex after visiting it and before visiting its adjacent vertices
 */
@FunctionalInterface
public interface PosVisit {
    /**
     * Visits a vertex after visiting its adjacent vertices
     * @param g the graph
     * @param v the vertex
     */
    void visit(Graph g, int v);
}
