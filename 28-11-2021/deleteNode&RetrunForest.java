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
    public TreeNode helper(TreeNode root, HashSet<Integer> hm, List<TreeNode>ans)
    {
        if(root == null)
            return null;
        root.left = helper(root.left,hm,ans);
        root.right = helper(root.right,hm,ans);
        if(hm.contains(root.val))
        {
            if(root.left != null)
                ans.add(root.left);
            if(root.right!= null)
                ans.add(root.right);
            return  null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if(root == null)
            return ans;
        HashSet<Integer> hm = new HashSet<>();
        for(int val : to_delete)
            hm.add(val);
        
        TreeNode a = helper(root,hm,ans);
        if(a!= null)
            ans.add(a);
        return ans;
    }
}