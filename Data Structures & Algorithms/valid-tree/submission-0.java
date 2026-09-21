class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int child, int parent, List<List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(child)) {
            return false;
        }

        visited.add(child);

        for (int nei : graph.get(child)) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, child, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}
