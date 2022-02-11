import java.util.*;

public class PrintAllBridges {

    private void printBridges(List<List<Integer>> adj, int N) {
        boolean[] vis = new boolean[N];
        int[] tin = new int[N]; // time to insert
        int[] low = new int[N]; // lowest time to insert

        int timer = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i])
                dfs(i, -1, vis, tin, low, adj, timer);
        }
    }

    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> adj, int timer) {
        vis[node] = true;
        tin[node] = low[node] = timer++;

        for (int it : adj.get(node)) {
            if (it == parent) {
                // if the adjacent node is parent itself, skip it from dfs
                continue;
            }
            if (!vis[it]) {
                dfs(it, node, vis, tin, low, adj, timer);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node]) {
                    // bridge found
                    System.out.println(it + " - " + node);
                }
            } else {
                // if its already a visited adj node,
                // check if its time to insertion is less than
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        PrintAllBridges obj = new PrintAllBridges();
        obj.printBridges(adj, n);

    }
}
