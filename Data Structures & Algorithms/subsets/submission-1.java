class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> curr) {
        res.add(new ArrayList<>(curr));

        for (int i=index; i<nums.length; i++) {
            curr.add(nums[i]);

            dfs(nums, i + 1, curr);

            curr.remove(curr.size() - 1);
        }
    }
}
