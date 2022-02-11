import java.util.*;
import java.lang.*;
import java.io.*;

class BFSIterative {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> sol = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int vtx = 0; vtx < V; vtx++) {
            q.add(vtx);
            while (!q.isEmpty()) {
                Integer node = q.poll();
                if (!visited[node]) {
                    visited[node] = true;
                    sol.add(node);
                    for (Integer i : adj.get(node)) {
                        if (!visited[i]) {
                            q.add(i);
                        }
                    }
                }
            }
        }
        return sol;
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
            }
            BFSIterative obj = new BFSIterative();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}