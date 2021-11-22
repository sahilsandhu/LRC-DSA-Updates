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
    class verticalpair{
    TreeNode node = null;
    int hl = 0;
    verticalpair(TreeNode node, int hl)
    {
        this.node = node;
        this.hl = hl;
    }
}

    public static void width(TreeNode root,int hl, int[]minMax)
    {
        if(root==null)
            return;
        minMax[0] = Math.min(minMax[0],hl);
        minMax[1] = Math.max(minMax[1],hl);
        width(root.left, hl-1, minMax);
        width(root.right,hl+1, minMax);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        PriorityQueue<verticalpair> que = new PriorityQueue<>((a,b)->{
            return a.node.val - b.node.val;
        });
         PriorityQueue<verticalpair> childq = new PriorityQueue<>((a,b)->{
            return a.node.val - b.node.val;
        });
        
        int[] minMax = new int[2];
        width(root,0,minMax);
        int len = minMax[1] - minMax[0] +1;
        for(int i=0;i<len;i++)
        {
            ans.add(new ArrayList<>());
        }
        
        que.add(new verticalpair(root,Math.abs(minMax[0])));
        while(que.size()!=0)
        {
            verticalpair rp = que.remove();
            ans.get(rp.hl).add(rp.node.val);
            if(rp.node.left !=null)
            {
               childq.add(new verticalpair(rp.node.left,rp.hl-1)); 
            }
            if(rp.node.right != null)
            {
                childq.add(new verticalpair(rp.node.right,rp.hl+1));
            }
            if(que.size()==0)
            {
             PriorityQueue<verticalpair> temp = que;
                que = childq;
                childq = temp;
            }
        }
        return ans;
        
    }
}