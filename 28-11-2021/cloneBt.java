/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
     public TreeNode leftcloned(TreeNode root)
     {
         if(root == null)
         return null;
         TreeNode l = leftcloned(root.left);
         TreeNode r = leftcloned(root.right);
         TreeNode temp = new TreeNode(root.val);
         temp.left = l;
         root.left = temp;
         root.right = r;
         return root;
     }

    //  public void upddatingrandom(TreeNode node)
    //  {
    //      if(root == null)
    //      return;
    //      if(root.random != null)
    //      root.left.random = root.random.left;
    //      upddatingrandom(root.left);
    //       upddatingrandom(root.right);
    //  }

     public TreeNode breakingNode(TreeNode root){
        if(root == null)
        {
            return null;
        }
        TreeNode tr = root.left;
        root.left = root.left.left;
        TreeNode l = breakingNode(root.left);
        TreeNode r = breakingNode(root.right);
        tr.left = l;
        tr.right = r;
        return tr;
     }


    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if(root == null)
        return null;
        TreeNode root1 = leftcloned(root);
       // upddatingrandom(root1);
        TreeNode node = breakingNode(root1);
        return node;
    }
}