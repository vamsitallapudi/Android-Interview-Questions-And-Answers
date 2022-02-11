import java.util.*;
import java.io.*;

public class TopologicalSortBFS {

    // https://practice.geeksforgeeks.org/problems/topological-sort/1
    // Function to return list containing vertices in Topological order.

    // Here we are using Kahn's Algorithm for finding topological sort using BFS

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topo = new int[V];
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            for (int it : adj.get(v)) {
                indegree[it]++; // code to get indegree
            }
        }
        for (int v = 0; v < V; v++) {
            if (indegree[v] == 0) {
                q.add(v);
            }
        }
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = TopologicalSortBFS.topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {

        if (V != res.length)
            return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v])
                    return false;
            }
        }
        return true;
    }
}
