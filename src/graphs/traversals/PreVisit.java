package graphs.traversals;

import graphs.Graph;

/**
 * Processes a vertex before visiting it and its adjacent vertices
 */
@FunctionalInterface
public interface PreVisit {
    /**
     * Visits a vertex before visiting its adjacent vertices
     * @param g the graph
     * @param v the vertex
     */
    void visit(Graph g, int v);
}
