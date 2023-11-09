import java.util.*;

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findSet(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = findSet(parent[i]);
    }

    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        parent[findSet(i)] = findSet(j);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<int[]> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int weight = scanner.nextInt();
                adj.add(new int[]{weight, u - 1, v - 1});
            }

            adj.sort(Comparator.comparingInt(a -> a[0]));

            UnionFind uf = new UnionFind(n);
            int minCost = 0;

            for (int[] edge : adj) {
                int weight = edge[0], u = edge[1], v = edge[2];
                if (!uf.isSameSet(u, v)) {
                    uf.unionSet(u, v);
                    minCost += weight;
                }
            }

            System.out.println(minCost);
        }
        scanner.close();
    }
}
