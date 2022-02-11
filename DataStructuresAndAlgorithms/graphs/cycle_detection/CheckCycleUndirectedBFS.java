import java.util.*;
import java.lang.*;
import java.io.*;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#

class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CheckCycleUndirectedBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        // traversing through components
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (isCycleExists(i, visited, adj))
                    return true; // don't return false here as
            // the other components needs to be processed
        }
        return false;
    }

    private boolean isCycleExists(int strt, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // insert the node into queue
        Queue<Node> q = new LinkedList<>(); // BFS
        q.add(new Node(strt, -1));
        visited[strt] = true;
        while (!q.isEmpty()) {
            Node n = q.poll();
            int first = n.first;
            int second = n.second;
            for (int i : adj.get(first)) {
                if (!visited[i]) { // check if its unvisited
                    visited[i] = true;
                    q.add(new Node(i, first));
                } else if (i != second) { // visited node, hence check if it is not parent
                    return true;
                }
            }
        }
        return false;
    }
}

class GFG {
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
                adj.get(v).add(u);
            }
            CheckCycleUndirectedBFS obj = new CheckCycleUndirectedBFS();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends
