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
    public void helper(TreeNode root, HashMap<Integer, ArrayList<Integer>> hm, int level)
    {
        if(root== null)
            return;
        if(!hm.containsKey(level)){
            hm.put(level, new ArrayList<>());
            hm.get(level).add(root.val);
        }
        else
        {
            hm.get(level).add(root.val);
        }
        helper(root.left,hm,level+1);
        helper(root.right,hm,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        helper(root,hm,0);
        for(int i=0;i<hm.size();i++)
        {
            ans.add(hm.get(i));
        }
        return ans;
    }
}