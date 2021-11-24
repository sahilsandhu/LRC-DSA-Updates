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
public static void width(TreeNode root, int lev, int[] minMax)
    {
        if(root== null)
        return;
        minMax[0] = Math.min(lev,minMax[0]);
        minMax[1] = Math.max(lev, minMax[1]);
        width(root.left, lev-1, minMax);
        width(root.right, lev+1, minMax);
    }
    public static class pair{
        TreeNode node=null;
        int hl=0;
        pair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
    }

    public static ArrayList<Integer> BottomView(TreeNode root) {
 if(root == null)
        return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[]minMax = new int[2];
        width(root,0,minMax);
        int length = minMax[1] - minMax[0] + 1;
        for(int i=0;i<length;i++)
        ans.add(null);
        LinkedList<pair> que = new LinkedList();
        que.addLast(new pair(root,Math.abs(minMax[0])));
        while(que.size()>0)
        {
            int size = que.size();
            while(size-- > 0)
            {
                pair rp = que.removeFirst();
                //if(ans.get(rp.hl) == null)
                ans.set(rp.hl,rp.node.val);
                
                if(rp.node.left != null)
                que.add(new pair(rp.node.left,rp.hl-1));
                if(rp.node.right != null)
                que.add(new pair(rp.node.right,rp.hl+1));
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