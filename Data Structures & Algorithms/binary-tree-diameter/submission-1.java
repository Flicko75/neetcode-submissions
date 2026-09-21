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
    public static int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return Solution.res;    
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        Solution.res = Math.max(Solution.res, left + right);
        return 1 + Math.max(left, right);
    }
}
