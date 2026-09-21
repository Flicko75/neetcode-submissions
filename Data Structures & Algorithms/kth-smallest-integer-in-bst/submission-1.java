/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> array = new ArrayList<>();
        dfs(root, array);
        return array.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> array) {
        if (root == null) return;

        dfs(root.left, array);
        array.add(root.val);
        dfs(root.right, array);
    }
}
