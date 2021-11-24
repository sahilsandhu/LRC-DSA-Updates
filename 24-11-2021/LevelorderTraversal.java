
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
    public List<List<Integer>> levelOrder(TreeNode root) {
       // Level order by Queue
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(que.size()>0)
        {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            while(size-- > 0)
            {
                TreeNode rp = que.remove();
                temp.add(rp.val);
                if(rp.left != null)
                    que.add(rp.left);
                if(rp.right != null)
                    que.add(rp.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}