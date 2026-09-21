class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n + 1];

        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }
    }

    public int find(int n) {
        if (parent[n] == n) {
            return n;
        }

        return find(parent[n]);
    }

    public void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            parent[A] = B;
        }
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=i + 1; j<n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        int res = 0;

        for (int[] edge : edges) {
            if (dsu.find(edge[0]) != dsu.find(edge[1])) {
                dsu.union(edge[0], edge[1]);
                res += edge[2];
            }
        }

        return res;
    }
}
