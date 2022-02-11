import java.util.*;

public class KruskalsAlgo {

    public void kruskalAlgo(List<Node> adj, int N) {
        Collections.sort(adj, (a, b) -> a.weight - b.weight);
        int parent[] = new int[N];
        int rank[] = new int[N];
        Arrays.fill(rank, 0);
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int totalCost = 0;
        List<Node> mst = new ArrayList<>();
        for (Node it : adj) {
            if (findPar(it.u, parent) != findPar(it.v, parent)) {
                totalCost += it.weight;
                mst.add(it);
                union(it.u, it.v, parent, rank);
            }
        }
        System.out.println(" total cost of MST: " + totalCost);
        for (Node n : mst) {
            System.out.println(n.u + " - " + n.v);
        }
    }

    private int findPar(int u, int[] parent) {
        if (u == parent[u])
            return u;
        return parent[u] = findPar(parent[u], parent);
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String args[]) {
        int n = 9;
        List<Node> adj = new ArrayList<Node>();

        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));

        KruskalsAlgo obj = new KruskalsAlgo();
        obj.kruskalAlgo(adj, n);

    }
}

class Node {
    int weight;
    int u;
    int v;

    Node(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
}
