class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] seen) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (seen[i]) {
                continue;
            }

            curr.add(nums[i]);
            seen[i] = true;

            dfs(nums, curr, seen);

            curr.remove(curr.size() - 1);
            seen[i] = false;
        }
    }
}
