import graphs.Graph;

public class Main {
    public static void main(String[] args) {
       Graph g = new Graph(7);
                      // 0  1  2  3  4  5  6
        int[][] edges = {{0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0}};
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
               g.setEdge(g, i, j, edges[i][j]);
            }
        }
        System.out.println("The graph is: ");
        g.printGraph(g);
        System.out.println("The number of vertices is: " + g.numVertices);
        System.out.println("The number of edges is: " + g.numEdges);





        // copilot create a function to print the graph
        //

    }
}