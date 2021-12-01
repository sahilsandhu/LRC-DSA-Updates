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
    public ArrayList<TreeNode> helper(int n)
    {
        if(n==1)
        {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }
        ArrayList<TreeNode> ans =new ArrayList<>();
        for(int i=1;i<n;i+=2)
        {
            ArrayList<TreeNode> left = helper(i) ;
            ArrayList<TreeNode> right = helper(n-i-1);
            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> allPossibleFBT(int n) {
       return  helper(n);
    }
}