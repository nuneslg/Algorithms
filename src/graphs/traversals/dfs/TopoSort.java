package graphs.traversals.dfs;

import graphs.Graph;
import stack.Stack;

/**
 * Performs a topological sort of a graph
 */
public class TopoSort extends DFS {
    public Stack<Integer> stack;
    public Graph g;

    public TopoSort(Graph g) {
        this.stack = new Stack<>();
        this.g = g;
    }

    @Override
    protected void preVisit(Graph g, int v) {

    }

    @Override
    protected void postVisit(Graph g, int v) {
        stack.push(stack, v);
    }
}
