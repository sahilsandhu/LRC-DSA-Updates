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

    public static void width(TreeNode root, int hl,int[] minMax)
    {
        if(root == null)
        return;
        minMax[0] = Math.min(hl, minMax[0]);
        minMax[1] = Math.max(hl,minMax[1]);
        width(root.left,hl-1,minMax);
        width(root.right,hl+1,minMax);
        
    }
    public static class vpair{
        TreeNode treenode = null;
        int level = 0;
        vpair(TreeNode treenode , int level)
        {
            this.treenode = treenode;
            this.level = level;
        }
    }
    public static ArrayList<Integer> BottomView(TreeNode root) {
        if(root == null)
        return new ArrayList<>();
        
        ArrayList<Integer> ans= new ArrayList<>();
    
        int[]minMax = new int[2];
        width(root,0,minMax);
        
        int wid = minMax[1]- minMax[0] +1;
        for(int i=0;i<wid;i++)
        ans.add(0);
        
        LinkedList<vpair> que = new LinkedList<>();
        que.add (new vpair(root,Math.abs(minMax[0])));
        while(que.size()!=0)
        {
             int size = que.size();
             while(size-- > 0)
             {
                 vpair rp = que.removeFirst();
                 TreeNode t = rp.treenode;
                 int hl = rp.level;
                 ans.set(hl,t.val);
                 if(t.left!=null)
                 que.addLast(new vpair(t.left,hl-1));
                 
                 if(t.right!=null)
                 que.addLast(new vpair(t.right,hl+1));
                 
             }
        }
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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}