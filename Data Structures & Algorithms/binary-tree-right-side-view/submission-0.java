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
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);

        return list;
    }

    private void dfs(TreeNode node, int level){
        if (node == null){
            return;
        }

        if (level == list.size()){
            list.add(node.val);
        }

        dfs(node.right, level + 1);

        dfs(node.left, level + 1);
    }
}
