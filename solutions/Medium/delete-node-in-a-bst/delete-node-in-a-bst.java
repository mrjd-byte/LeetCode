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
    public TreeNode deleteNode(TreeNode mainRoot, int key) {
        TreeNode temp = null;
        TreeNode root = mainRoot;
        TreeNode prev = null;

        while (root != null) {
            if (key > root.val) {
                prev = root;
                root = root.right;
            } else if (key < root.val) {
                prev = root;
                root = root.left;
            } else {
                temp = root;
                break;
            }
        }

        if (temp == null) {
            return mainRoot;
        }

        TreeNode replacement;

        if (temp.left == null) {
            replacement = temp.right;
        } else if (temp.right == null) {
            replacement = temp.left;
        } else {
            TreeNode rightSide = temp.right;
            TreeNode leftSide = temp.left;

            TreeNode tem = leftSide;

            while (tem.right != null) {
                tem = tem.right;
            }

            tem.right = rightSide;
            replacement = leftSide;
        }

        if (prev == null) {
            return replacement;
        }

        if (prev.left == temp) {
            prev.left = replacement;
        } else {
            prev.right = replacement;
        }

        return mainRoot;
    }
}