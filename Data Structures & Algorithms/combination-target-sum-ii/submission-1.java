class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;    
    }

    private void dfs(int[] nums, int target, int i, int sum){
        if (sum == target){
            res.add(List.copyOf(curr));
            return;
        }

        if (i == nums.length || sum > target){
            return;
        }

        curr.add(nums[i]);
        dfs(nums, target, i + 1, sum + nums[i]);

        curr.remove(curr.size() - 1);
        int next = i + 1;

        while (next < nums.length && nums[next] == nums[i]){
            next++;
        }
        dfs(nums, target, next, sum);
    }
}
