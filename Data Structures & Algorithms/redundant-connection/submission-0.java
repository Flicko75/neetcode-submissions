class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];

        for (int i=0; i<n; i++) {
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
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length + 1);
        int[] answer = new int[1];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if (dsu.find(a) == dsu.find(b)) {
                answer = edge;
            }

            dsu.union(a, b);
        }

        return answer;
    }
}
