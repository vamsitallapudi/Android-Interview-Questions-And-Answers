import java.util.*;
import java.io.*;

// checking if its a bipartite graph using BFS
// Question link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1#
public class BipartiteGraph {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[V];
        Arrays.fill(color, -1);
        // Solution
        for (int v = 0; v < V; v++) {
            if (color[v] == -1) { // => unvisited component
                q.add(v);
                color[v] = 0;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    int parentC = color[node];
                    // iterate through adj nodes
                    for (int i : adj.get(node)) {
                        int c = color[i];
                        if (c == -1) {
                            // unvisited => color it and add to queue
                            color[i] = 1 - parentC;
                            q.add(i);
                        } else if (c == parentC) {
                            // not bipartite
                            return false;
                        }
                    }
                }
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
            BipartiteGraph obj = new BipartiteGraph();
            boolean ans = obj.isBipartite(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

}
