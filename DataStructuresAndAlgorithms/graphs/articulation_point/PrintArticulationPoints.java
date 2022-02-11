import java.util.*;

import javafx.scene.Parent;

// Java Program to Print all Articulation Points
// Articulation point - Node whose removal leads to two or more components.
public class PrintArticulationPoints {

    private void printArticulationPts(List<List<Integer>> adj, int N) {
        int[] lti = new int[N]; // lowest time to insert
        int[] tti = new int[N]; // time to insert
        boolean[] vis = new boolean[N]; // keep tracking if node is visited

        boolean isArticulation[] = new boolean[N];
        int ttn = 0; // time till now
        for (int i = 0; i < N; i++) {
            if (!vis[i])
                dfs(i, -1, vis, lti, tti, isArticulation, adj, ttn);
        }
        for (int i = 0; i < isArticulation.length; i++) {
            if (isArticulation[i])
                System.out.println(i);
        }
    }

    private void dfs(int node, int par, boolean[] vis, int[] lti, int[] tti, boolean[] isArticulation,
            List<List<Integer>> adj, int ttn) {
        vis[node] = true;
        tti[node] = lti[node] = ttn++;
        int child = 0;
        for (Integer it : adj.get(node)) {
            if (it == par) {
                continue; // go to next child
            }
            if (!vis[it]) {
                dfs(it, node, vis, lti, tti, isArticulation, adj, ttn);
                lti[node] = Math.min(lti[node], lti[it]);
                if (lti[it] >= tti[node] && par != -1) // articulation node found
                    isArticulation[node] = true;
                child++;
            } else {
                lti[node] = Math.min(lti[node], tti[it]);
            }
        }
        if (par != -1 && child > 1) // condition for last eg. given in notes
            isArticulation[node] = true;
    }

    public static void main(String args[]) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        PrintArticulationPoints obj = new PrintArticulationPoints();
        obj.printArticulationPts(adj, n);

    }
}
