package flattenBinaryTreeToLinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public void flatten(TreeNode root) {
        // Base case: no child nodes
        if (root == null) return;
        // flatten the right subtree
        flatten(root.right);
        if (root.left == null) return; // Finished
        // flatten the left subtree
        // then insert the flattened left
        // subtree between the root and the flattened right subtree
        flatten(root.left);
        TreeNode leftTail = root.left;
        while (leftTail.right != null) leftTail = leftTail.right;
        leftTail.right = root.right;
        root.right = root.left;
        root.left = null;
    }

}