import java.util.*;

public class TopologicalSortKahns {

    // Function to perform Topological Sort using Kahn's Algorithm
    static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        List<Integer> topoOrder = new ArrayList<>();

        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue to process nodes with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the graph
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            // Decrease the in-degree of neighbors and add them to queue if in-degree becomes 0
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycles (if not all nodes are processed, the graph is not a DAG)
        if (topoOrder.size() != V) {
            throw new RuntimeException("Graph is not a Directed Acyclic Graph (DAG)");
        }

        return topoOrder;
    }

    // Driver code
    public static void main(String[] args) {
        // Number of nodes
        int V = 6;

        // Edges (directed graph)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Perform Topological Sort
        List<Integer> result = topologicalSort(V, adj);
        System.out.println("Topological Sorting of the graph: " + result);
    }
}
