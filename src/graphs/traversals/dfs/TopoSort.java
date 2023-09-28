package graphs.traversals.dfs;

import graphs.Graph;
import stack.Stack;

/**
 * Performs a topological sort of a graph
 */
    class TopoSort extends DFS<Stack<Integer>> {
    public Stack<Integer> stack;


    public TopoSort() {
        this.stack = new Stack<>();
    }

    @Override
    protected void preVisit(Graph g, int v) {

    }

    @Override
    protected Stack<Integer> postVisit(Graph g, int v) {
        stack.push(stack, v);
        return stack;
    }
}
