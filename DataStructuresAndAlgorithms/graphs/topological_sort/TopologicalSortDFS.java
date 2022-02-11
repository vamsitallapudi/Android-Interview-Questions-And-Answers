import java.util.*;
import java.io.*;

public class TopologicalSortDFS {

    // https://practice.geeksforgeeks.org/problems/topological-sort/1
    // Function to return list containing vertices in Topological order.

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] sol = new int[V];
        int i = 0;
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>(); // stack to process children first parent next
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                topologicalDFS(v, visited, stack, adj);
            }
        }
        while (!stack.isEmpty()) {
            sol[i++] = stack.pop();
        }
        return sol;
    }

    private static void topologicalDFS(
            int v, boolean visited[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[v])
                topologicalDFS(i, visited, stack, adj);
        }
        stack.push(v); // adding after children are processed
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

            int[] res = TopologicalSortDFS.topoSort(nov, list);

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
