// pathSum 1 
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
     if(root == null)
         return false;
     if(root.left == null && root.right == null && targetSum - root.val == 0)
         return true;
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}


//pathsum - 2

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
    public void helper(TreeNode root, List<List<Integer>> ans, List<Integer> smallans,int targetSum)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null && targetSum- root.val == 0)
        {
            smallans.add(root.val);
           ans.add(new ArrayList<>(smallans));
            smallans.remove(smallans.size()-1);
            return;
        }
        smallans.add(root.val);
        helper(root.left,ans,smallans,targetSum - root.val);
        helper(root.right,ans,smallans,targetSum - root.val);
        smallans.remove(smallans.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        List<Integer> smallans = new ArrayList<>();
        helper(root,ans,smallans,targetSum);
        return ans;
    }
}

//path sum - 3

