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
     *
     * @param v the vertex
     * @return the index of the vertex if it exists, otherwise the number of vertices
     */
    public int first(int v) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.matrix[v][i] != 0) {
                return i;
            }
        } return this.numVertices;
    }

    /**
     * The index of the first vertex that v is adjacent to after w
     *
     * @param v the first vertex
     * @param w the second vertex
     * @return the index of the vertex if it exists, otherwise the number of vertices
     */
    public int next(int v, int w) {
        for (int i = w + 1; i < this.numVertices; i++) {
            if (this.matrix[v][i] != 0) {
                return i;
            }
        } return this.numVertices;
    }

    /**
     * Adds or updates an edge between two vertices
     *
     * @param i  the first vertex
     * @param j  the second vertex
     * @param wt the weight of the edge
     */
    public void setEdge(int i, int j, int wt) {
        if (wt != 0) { // if the weight is not 0 (i.e. the edge exists)
            if (this.matrix[i][j] == 0) {
                this.numEdges++; // increment the number of edges if the edge does not exist
            }
            this.matrix[i][j] = wt; // set the weight of the edge without updating number of edges if it already exists
        }
    }

    /**
     * Removes an edge between two vertices
     *
     * @param i the first vertex
     * @param j the second vertex
     */
    public void delEdge(int i, int j) {
        if (this.matrix[i][j] != 0) {
            this.numEdges--; // decrement the number of edges if the edge exists
        }
        this.matrix[i][j] = 0;
    }

    /**
     * Sets the mark of a vertex
     *
     * @param v   the vertex
     * @param val the value (1 for VISITED and 0 for UNVISITED)
     */
    public void setMark(int v, int val) {
        this.mark[v] = val;
    }

    /**
     * Gets the mark of a vertex
     *
     * @param v the vertex
     * @return the value (1 for VISITED and 0 for UNVISITED)
     */
    public int getMark(int v) {
        return this.mark[v];
    }

    public int weight(int i, int j) {
        if (this.matrix[i][j] == 0) {
            return Integer.MAX_VALUE;
        }
        return this.matrix[i][j];
    }

    public void printGraph() {
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}


