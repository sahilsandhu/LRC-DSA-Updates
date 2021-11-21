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
    public static void width(TreeNode root,int[] minMax,int level)
    {
        if(root == null)
        return;
        minMax[0] = Math.min(minMax[0],level);
        minMax[1] = Math.max(minMax[1],level);
        width(root.left,minMax,level-1);
        width(root.right,minMax,level+1);
    }
    public static void verticalsolve(TreeNode root,ArrayList<ArrayList<Integer>> ans, int level)
    {
        if(root == null)
        return;
        ans.get(level).add(root.val);
        verticalsolve(root.left,ans,level-1);
        verticalsolve(root.right,ans,level+1);
    }
    
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
    if(root == null)
    return new ArrayList<>();
    int minMax[] = new int[2];
    width(root,minMax,0);
    int size = minMax[1] - minMax[0]+1;
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for(int i=0;i<size;i++)
    {
        ans.add(new ArrayList<>());
    }
    verticalsolve(root,ans,size/2);
    return ans;
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}