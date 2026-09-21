class Solution {
    private List<String> res = new ArrayList<>();
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            graph.computeIfAbsent(u, k -> new PriorityQueue<>()).offer(v);
        }

        dfs("JFK");

        Collections.reverse(res);
        return res;
    }

    private void dfs(String airport) {
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            dfs(graph.get(airport).poll());
        }
        res.add(airport);
    }
}
