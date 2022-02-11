import java.util.*;

// to detect cycle in a Directed Graph using BFS -> Kahn's Algo
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class CycleDetectionBFS {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int[] topo = new int[V]; // using the logic of topological sort kahn's algo
        // calculate indegree
        for (int v = 0; v < V; v++) {
            for (int it : adj.get(v)) {
                indegree[it]++;
            }
        }
        // check if any indegree and add to queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[count++] = node;
            for (int j : adj.get(node)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.add(j);
                }
            }
        }
        if (count == V) // -> checking if elements in topo array
            return false;
        return true;
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
            if (new CycleDetectionBFS().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
        sc.close();
    }
}
