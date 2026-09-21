class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> depGraph = new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            depGraph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int need = pre[1];

            depGraph.get(need).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int visited = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            visited++;

            for (int dep : depGraph.get(course)) {
                if (--inDegree[dep] == 0) {
                    q.offer(dep);
                }
            }
        }

        return visited == numCourses;
    }
}
