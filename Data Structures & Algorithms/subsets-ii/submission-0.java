class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    private void dfs(int idx, int[] nums, List<Integer> curr){
        res.add(new ArrayList<>(curr));

        for (int i=idx; i<nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            curr.add(nums[i]);

            dfs(i + 1, nums, curr);

            curr.remove(curr.size() - 1);
        }
    }
}
