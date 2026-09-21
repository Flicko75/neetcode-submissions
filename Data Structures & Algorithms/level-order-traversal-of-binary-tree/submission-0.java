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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();

            // int size = queue.size();

            for (int i=queue.size() - 1; i>=0; i--){
                TreeNode node = queue.poll();

                if (node != null){
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!list.isEmpty()){
                res.add(list);
            }
        }

        return res;
    }
}
