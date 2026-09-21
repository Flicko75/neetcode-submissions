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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        dfsSerial(root, sb);

        return sb.toString();
    }

    private void dfsSerial(TreeNode node, StringBuilder sb){
        if (node == null){
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerial(node.left, sb);
        dfsSerial(node.right, sb);
    }

    int i = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");

        return dfsDeserial(vals);
    }

    private TreeNode dfsDeserial(String[] vals){
        if (vals[i].equals("N")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
        i++;

        node.left = dfsDeserial(vals);
        node.right = dfsDeserial(vals);

        return node;
    }
}
