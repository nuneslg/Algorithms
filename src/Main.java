import graphs.Graph;
import graphs.traversals.dfs.TopoSort;

public class Main {
    public static void main(String[] args) {
        long initialTime = System.nanoTime();
        Graph g = getGraph();
        System.out.println("The graph is: ");
        g.printGraph(g);
        System.out.println("\nThe number of vertices is: " + g.numVertices);
        System.out.println("The number of edges is: " + g.numEdges);


        System.out.println("\nExecuting Topological Sort...");
        TopoSort topoSort = new TopoSort(g);
        topoSort.graphTraverse(g, 0);
        System.out.println("The dependencies are:");
        for (int i = 0; i < g.numVertices; i++) {
            if (i != g.numVertices - 1) {
                System.out.print(topoSort.stack.pop(topoSort.stack) + 1 + " >> ");
            } else {
                System.out.print(topoSort.stack.pop(topoSort.stack) + 1);
            }
        }
        getRunTime(initialTime);

    }

public static void getRunTime(long initialTime) {
    long finalTime = System.nanoTime();
    long totalTime = finalTime - initialTime;
    double ms = (double) totalTime / 1000000.0;
        System.out.println("\n\nThe execution time was: " + ms + " ms");
    }

    private static Graph getGraph() {
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
        return g;
    }
}