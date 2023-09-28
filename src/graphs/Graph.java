package graphs;

public class Graph {
    public int[][] matrix; // adjacency matrix
    public int numEdges; // number of edges for each vertex
    public int[] mark; // auxiliary marking array
    public final int numVertices; // number of vertices

    /**
     * Creates a graph with n vertices and no edges.
     * Implicit assumption: 0 weight value denotes the absence of an edge between two nodes
     * @param n the number of vertices
     */
    public Graph(int n) {
        this.matrix = new int[n][n];
        this.numEdges = 0;
        this.mark = new int[n];
        this.numVertices = n;
    }

    /**
     * The index of the first vertex after a given vertex that is adjacent to it
     * @param g the graph
     * @param v the vertex
     * @return the index of the vertex if it exists, otherwise the number of vertices
     */
    public int first(Graph g, int v) {
        for (int i = 0; i < g.numVertices; i++) {
            if (g.matrix[v][i] != 0) {
                return i;
            }
        } return g.numVertices;
    }

    /**
     * The index of the first vertex that v is adjacent to after w
     * @param g the graph
     * @param v the first vertex
     * @param w the second vertex
     * @return the index of the vertex if it exists, otherwise the number of vertices
     */
    public int next(Graph g, int v, int w) {
        for (int i = w + 1; i < g.numVertices - 1; i++) {
            if (g.matrix[v][i] != 0) {
                return i;
            }
        } return g.numVertices;
    }

    /**
     * Adds or updates an edge between two vertices
     * @param g the graph
     * @param i the first vertex
     * @param j the second vertex
     * @param wt the weight of the edge
     */
    public void setEdge(Graph g, int i, int j, int wt) {
        if (wt != 0) { // if the weight is not 0 (i.e. the edge exists)
            if (g.matrix[i][j] == 0) {
                g.numEdges++; // increment the number of edges if the edge does not exist
            }
            g.matrix[i][j] = wt; // set the weight of the edge without updating number of edges if it already exists
        }
    }

    /**
     * Removes an edge between two vertices
     * @param g the graph
     * @param i the first vertex
     * @param j the second vertex
     */
    public void delEdge(Graph g, int i, int j) {
        if (g.matrix[i][j] != 0) {
            g.numEdges--; // decrement the number of edges if the edge exists
        }
        g.matrix[i][j] = 0;
    }

    /**
     * Sets the mark of a vertex
     * @param g the graph
     * @param v the vertex
     * @param val the value (1 for VISITED and 0 for UNVISITED)
     */
    public void setMark(Graph g, int v, int val) {
        g.mark[v] = val;
    }

    /**
     * Gets the mark of a vertex
     * @param g the graph
     * @param v the vertex
     * @return the value (1 for VISITED and 0 for UNVISITED)
     */
    public int getMark(Graph g, int v) {
        return g.mark[v];
    }

    public void printGraph(Graph g) {
        for (int i = 0; i < g.numVertices; i++) {
            for (int j = 0; j < g.numVertices; j++) {
                System.out.print(g.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}


