import java.util.*;
import java.lang.*;
import java.io.*;

class BFSRecursive {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            q.add(i);
            bfs(q, sol, adj, visited);
        }
        return sol;
    }

    private void bfs(Queue<Integer> q, ArrayList<Integer> sol,
            ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Integer node = q.poll();
        if (node == null) {
            return;
        }
        if (!visited[node]) {
            visited[node] = true;
            sol.add(node);
            for (Integer a : adj.get(node)) {
                if (!visited[a]) {
                    q.add(a);
                }
            }
        }
        bfs(q, sol, adj, visited);
    }
}

class BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            BFSRecursive obj = new BFSRecursive();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends