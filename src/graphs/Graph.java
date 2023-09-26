package graphs;

public class Graph {
    private int[][] matrix; // adjacency matrix
    private int numEdges; // number of edges for each vertex
    private int[] mark; // auxiliary marking array
    private final int numVertices; // number of vertices

    public int[][] getMatrix(Graph g) {
        return g.matrix;
    }

    public int getNumEdges(Graph g) {
        return g.numEdges;
    }

    public int getNumVertices(Graph g) {
        return g.numVertices;
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
    protected int first(Graph g, int v) {
        for (int i = 0; i < g.numVertices - 1; i++) {
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
    protected int next(Graph g, int v, int w) {
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
    private void setEdge(Graph g, int i, int j, int wt) {
        if (wt == 0) {
            System.out.println("Cannot set weight to 0");
        } else {
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
    private void delEdge(Graph g, int i, int j) {
        if (g.matrix[i][j] != 0) {
            g.numEdges--; // decrement the number of edges if the edge exists
        }
        g.matrix[i][j] = 0;
    }

}


