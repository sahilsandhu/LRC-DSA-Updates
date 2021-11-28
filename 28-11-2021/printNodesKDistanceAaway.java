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
  public static void kdown(TreeNode root,int k,TreeNode block,ArrayList<Integer> ans)
  {
      if(k==0 || root == null || root == block)
      {
      if (root == null || root == block) {
                return;
            }
            ans.add(root.val);
            return;

      }
      kdown(root.left,k-1,block,ans);
      kdown(root.right,k-1,block,ans);
  }
  public  static ArrayList<TreeNode> nodeToRootPath(TreeNode node,int target)
  {
    if(node == null)
    return new ArrayList<>();
    if(node.val == target)
    {
        ArrayList<TreeNode> base = new ArrayList<>();
        base.add(node);
        return base;
    }
    ArrayList<TreeNode> left = nodeToRootPath(node.left, target);
    if(left.size()>0)
    {
        left.add(node);
        return left;
    }
    ArrayList<TreeNode> right = nodeToRootPath(node.right, target);
    if(right.size()>0)
    {
        right.add(node);
        return right;
    }
    return new ArrayList<>();

  }

  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    if(root == null)
    return new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<TreeNode> nrp = nodeToRootPath(root,target);
    TreeNode block = null;
    for(int i=0;i<nrp.size();i++)
    {
        kdown(nrp.get(i),k-i,block,ans);
        block = nrp.get(i);
    }
    return ans;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);
    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}