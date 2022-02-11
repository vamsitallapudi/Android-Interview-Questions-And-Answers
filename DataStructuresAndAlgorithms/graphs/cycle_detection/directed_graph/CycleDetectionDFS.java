import java.util.*;

// to detect cycle in a Directed Graph using DFS
public class CycleDetectionDFS {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                if (dfs(v, visited, dfsVisited, adj))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visited, boolean[] dfsVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        dfsVisited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                // unvisited node, perform dfs.
                if (dfs(i, visited, dfsVisited, adj))
                    return true;
            } else if (dfsVisited[i]) {
                // visited in current traversal as well as overall traversal
                return true;
            }
        }
        dfsVisited[v] = false; // marking as unvisited once traversing back from recursion
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new CycleDetectionDFS().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
        sc.close();
    }
}
