import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode construct(int[] postorder, int ps,int pe,int[]inorder,int is,int ie)
    {
        if(is > ie)
        return null;
      TreeNode node = new TreeNode(postorder[pe]); 
      int idx = is;
      while(inorder[idx]!=postorder[pe])
      {
          idx++;
      }
      int count = idx - is;
      node.left = construct(postorder,ps,ps+count-1,inorder,is,idx-1);
      node.right = construct(postorder,ps+count,pe-1,inorder,idx+1,ie);
      return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(postorder, 0, postorder.length-1,inorder,0,inorder.length-1);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}