import java.util.*;
import java.io.*;

// checking if its a bipartite graph using BFS
// Question link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1#

public class BipartiteGraphDFS {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int v = 0; v < V; v++) {
            if (color[v] == -1) {
                if (!dfs(v, color, adj))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int v, int[] color, ArrayList<ArrayList<Integer>> adj) {
        int pc = color[v];
        for (int i : adj.get(v)) {
            if (color[i] == -1) {
                color[i] = 1 - pc;
                if (!dfs(i, color, adj))
                    return false;
            } else if (color[i] == pc) {
                return false;
            }
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            BipartiteGraphBFS obj = new BipartiteGraphBFS();
            boolean ans = obj.isBipartite(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
