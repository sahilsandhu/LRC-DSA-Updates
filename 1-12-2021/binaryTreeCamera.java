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
    static int camera = 0;
    public int countCamera(TreeNode node)
    {
        if(node == null)
            return 1;
        int leftc =  countCamera(node.left);
        int rightc = countCamera(node.right);
        if(leftc == -1 || rightc == -1)
        {
            camera++;
            return 0;
        }
        if(leftc == 0 || rightc == 0)
            return 1;
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        if(root == null)
            return 1;
        camera = 0;
        if(countCamera(root) == -1)
            camera++;
        return camera;
    }
}