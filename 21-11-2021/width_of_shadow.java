import java.util.*;

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
    public static void findwidth(TreeNode root,int[] maxMin,int level)
    {
        if(root == null)
        return ;
        maxMin[0] = Math.min(maxMin[0],level);
        maxMin[1] = Math.max(maxMin[1],level);
        findwidth(root.left,maxMin,level-1);
        findwidth(root.right,maxMin, level+1);
    }

    public static int width(TreeNode root) {
       if(root == null)
       return 0;
       int[] maxMin = new int[2]; 
       findwidth(root,maxMin,0);
       return maxMin[1]-maxMin[0]+1;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
