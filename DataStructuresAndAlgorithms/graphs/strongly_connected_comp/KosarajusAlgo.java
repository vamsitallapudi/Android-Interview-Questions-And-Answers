import java.util.*;

public class KosarajusAlgo {

    public void kosarajuAlgo(int N, List<List<Integer>> adj) {
        // Step - I -> Toposort
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, s, vis, adj);
            }
        }
        // Step - II -> Transpose
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int it : adj.get(i)) {
                // previously there's an edge from i to it
                // transposing that edge => creating edge from it to i
                transpose.get(it).add(i);
            }
        }
        // refilling visited to false
        Arrays.fill(vis, false);

        // Step - III -> Perform DFS on Transposed graph
        while (!s.isEmpty()) {
            int node = s.pop();
            if (!vis[node]) {
                System.out.print("SCC: ");
                printDFS(node, transpose, vis);
                System.out.println();
            }
        }
    }

    private void dfs(int node, Stack<Integer> s, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (Integer child : adj.get(node)) {
            if (!vis[child]) {
                dfs(child, s, vis, adj);
            }
        }
        s.push(node); // In toposort, whenever we're leaving, we'll insert into queue
    }

    private void printDFS(int node, List<List<Integer>> transpose, boolean[] vis) {
        vis[node] = true;
        System.out.print(node + " ");
        for (Integer it : transpose.get(node)) {
            if (!vis[it]) {
                printDFS(it, transpose, vis);
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

        KosarajusAlgo obj = new KosarajusAlgo();
        obj.kosarajuAlgo(n, adj);

    }
}
