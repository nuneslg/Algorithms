package graphs;

public class DFS extends Traversal {

    /**
     * Traverses a graph using depth-first search
     * @param g the graph
     * @param v the vertex
     */
    @Override
    public void traverse(Graph g, int v) {
       // preVisit(g, v);
        g.setMark(g,v, 1);
        int w = g.first(g,v);
        while (w < g.getNumVertices(g)) {
            if (g.getMark(g, w) == 0) {
                traverse(g, w);
            }
            w = g.next(g, v, w);
        }
      //  postVisit(g, v);
    }
}
