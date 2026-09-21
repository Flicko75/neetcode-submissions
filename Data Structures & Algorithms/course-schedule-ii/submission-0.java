class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int need = pre[1];

            graph.get(need).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int finish = 0;
        int i = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            res[i] = course;
            finish++;

            for (int nei : graph.get(course)) {
                inDegree[nei]--;

                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }

            i++;
        }

        return (finish == numCourses) ? res : new int[] {};
    }
}
