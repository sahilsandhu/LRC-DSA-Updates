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
class CBTInserter {

    Queue<TreeNode> q = new LinkedList<>();
    TreeNode head = null;
    TreeNode nip = null;
    public CBTInserter(TreeNode root) {
        q.add(root);
        head = root;
        while(true)
        {
            TreeNode top = q.poll();
            if(top.left != null)
            {
                q.add(top.left);
            }
            else
            {
                nip = top;
                    break;
            }
            if(top.right != null)
            {
                q.add(top.right);
            }
            else
            {
                nip =  top;
                break;
            }
        }
    }
    
    public int insert(int val) {
        int v = nip.val;
        TreeNode node = new TreeNode(val);
      
            if(nip.left == null){
                nip.left = node;
                q.add(nip.left);
            }
            else if(nip.right == null)
            {
                nip.right = node;
                q.add(nip.right);
                nip = q.poll();
            }
        return v; 
        
    }
    
    public TreeNode get_root() {
        return head;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */