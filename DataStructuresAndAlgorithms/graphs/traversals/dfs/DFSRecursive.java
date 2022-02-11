import java.util.*;
import java.io.*;

class DFSRecursive {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            dfs(i, visited, sol, adj);
        }
        return sol;
    }

    private void dfs(Integer node, boolean[] visited, ArrayList<Integer> sol,
            ArrayList<ArrayList<Integer>> adj) {
        if (node == null) {
            return;
        }
        if (!visited[node]) {
            visited[node] = true;
            sol.add(node);
            for (Integer i : adj.get(node)) {
                dfs(i, visited, sol, adj);
            }
        }
    }
}

class DriverCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            DFSRecursive obj = new DFSRecursive();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
