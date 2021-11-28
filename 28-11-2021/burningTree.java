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

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
      if(root == null)
      return new ArrayList<>();
      HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();          burningTree_(root, data, hm);
    int i = 0;
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    while(hm.containsKey(i))
    {
        ans.add(hm.get(i));
        i++;
    }
    return ans;
  }
  public static int burningTree_(TreeNode node, int data, HashMap<Integer,ArrayList<Integer>> hm)
  {
    if(node == null)
      return -1;
    if(node.val == data)
    {
        allaway(node, null,0, hm);
        return 1;
    }
    int left = burningTree_(node.left,data,hm);
    if(left!=-1)
    {
        allaway(node,node.left,left,hm);
        return left+1;
    }
    int right = burningTree_(node.right,data,hm);
    if(right!=-1)
    {
        allaway(node,node.right,right,hm);
        return right+1;
    }
    return -1;
  }
  public static void allaway(TreeNode node,TreeNode blocker,int time, HashMap<Integer,ArrayList<Integer>> hm)
  {
      if(node==null || node == blocker)
      return;
      if(!hm.containsKey(time))
      {
          hm.put(time, new ArrayList<>());
      }
      hm.get(time).add(node.val);
      allaway(node.left,blocker,time+1,hm);
      allaway(node.right,blocker,time+1,hm);
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
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}