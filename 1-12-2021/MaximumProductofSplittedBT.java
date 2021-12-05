 public static long modulo = (int)1e9 + 7;
    public static long totalsum = 0;
    public static long product = -(int)1e9;
    public long sum(TreeNode root)
    {
        if(root == null)
            return 0;
        return sum(root.left) + sum(root.right) + root.val;
    }
    public long helper(TreeNode root)
    {
        if(root == null)
            return 0;
        long l = helper(root.left);
        long r = helper(root.right);
        product = Math.max(product,Math.max(l*(totalsum-l),r*(totalsum - r)));
        return l+r+root.val;
    }
    
    public int maxProduct(TreeNode root) {
        if(root == null)
          return 0;
        totalsum = sum(root);
        product = -(int)1e9;
        helper(root);
        return (int)(product%modulo);
    }
}