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
    public int height(TreeNode node)
    {
        if(node == null)
            return -1;
        return Math.max(height(node.left),height(node.right))+1;
    }
    public int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int ld = helper(root.left);
        int rd = helper(root.right);
        int h = height(root.left) + height(root.right) + 2;
        return Math.max(ld,Math.max(rd,h));
    }
    public int diameterOfBinaryTree(TreeNode root) {
      return   helper(root); 
    }
}



/// Diameter 2

class Solution {
    public static int dia = 0;
    public int helper(TreeNode root)
    {
        if(root == null)
            return -1;
        int lh = helper(root.left);
        int rh = helper(root.right);
        int th = Math.max(lh,rh)+1;
        if(lh + rh + 2 > dia)
            dia = lh + rh + 2;
        return th;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        helper(root);
        return dia;
    }
}


///    Diameter 3

class Solution {
    public class pair{
        int ht = -1;
        int dia = 0;
        pair(int ht,int dia)
        {
            this.ht = ht;
            this.dia = dia;
        }
    }
    public pair helper(TreeNode root)
    {
        if(root == null)
            return new pair(-1, 0);
        pair l = helper(root.left);
        pair r = helper(root.right);
        pair ans = new pair(0,0);
        ans.ht = Math.max(l.ht,r.ht)+1;
        ans.dia = Math.max(l.ht + r.ht + 2,Math.max(l.dia,r.dia));
        return ans;
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        pair ans = helper(root);
        return ans.dia;
    }
}