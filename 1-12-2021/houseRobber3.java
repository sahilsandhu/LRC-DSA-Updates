class pair{
    int ri = 0;
    int re = 0;
    pair(int ri,int re)
    {
        this.ri = ri;
        this.re = re;
    }
}
class Solution {
    public pair helper(TreeNode root)
    {
        if(root == null)
            return new pair(0,0);
        pair l = helper(root.left);
        pair r = helper(root.right);
        int ci = root.val + l.re + r.re;
        int ce = Math.max(l.ri,l.re) + Math.max(r.ri,r.re);
        return new pair(ci,ce);
    }
    public int rob(TreeNode root) {
        pair p = helper(root);
        return Math.max(p.ri,p.re);
    }
}