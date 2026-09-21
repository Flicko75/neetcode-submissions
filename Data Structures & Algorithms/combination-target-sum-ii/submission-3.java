class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) return;

        for (int i=index; i<nums.length; i++) {
            curr.add(nums[i]);

            dfs(nums, target - nums[i], i + 1, curr);

            curr.remove(curr.size() - 1);

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
