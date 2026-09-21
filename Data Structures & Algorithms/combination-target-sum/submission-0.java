class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0);

        return res;
    }

    private void dfs(int[] nums, int target, int i, int sum){
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        if ( sum > target || i == nums.length){
            return;
        }

        list.add(nums[i]);
        dfs(nums, target, i, sum + nums[i]);

        list.remove(list.size() - 1);
        dfs(nums, target, i + 1, sum);
    }
}
