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
public class state{
    TreeNode node;
    boolean sd;
    boolean ld;
    boolean rd;
    state(TreeNode node, boolean sd,boolean ld,boolean rd)
    {
        this.node = node;
        this.sd = sd;
        this.ld = ld;
        this.rd = rd;
    }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Stack<state> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(new state(root,false,false,false));
        while(st.size()>0)
        {
            state rp = st.peek();
            // st.pop();
            if(rp.ld == false)
            {
                if(rp.node.left != null)
                st.push(new state(rp.node.left,false,false,false));
                
                rp.ld = true;
            } 
            else if(rp.sd == false)
            {
                
                ans.add(rp.node.val);
                // st.push(new state(rp.node,true,rp.ld,rp.rd));
                rp.sd = true;
            }
            else if(rp.rd == false)
            {
                if(rp.node.right!=null)
                st.push(new state(rp.node.right,false,false,false));
                rp.rd = true;
            }  
            else
            {
                st.pop();
            }
        }
        return ans;
    }
}