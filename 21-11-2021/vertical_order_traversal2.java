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

  public static class verticalpair {
    TreeNode node =  null;
    int hl = 0;
    verticalpair(TreeNode node, int hl)
    {
      this.node = node;
      this.hl = hl;
    }
  }

  public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
    LinkedList<verticalpair> que = new LinkedList<>();
    que.addLast(new verticalpair(root, 0));
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int minhl = 0;
    int maxhl = 0;
    while (que.size() != 0)
    {
      int size = que.size();
      while (size-- > 0)
      {
        verticalpair rp = que.removeFirst();
        map.putIfAbsent(rp.hl, new ArrayList<>());
        map.get(rp.hl).add(rp.node.val);
        minhl = Math.min(minhl, rp.hl);
        maxhl = Math.max(maxhl, rp.hl);

        if (rp.node.left != null)
          que.addLast(new verticalpair(rp.node.left, rp.hl - 1));
        if (rp.node.right != null)
          que.addLast(new verticalpair(rp.node.right, rp.hl + 1));

      }

      
      
    }
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      while (minhl <= maxhl)
      {
        ans.add(map.get(minhl));
        minhl++;
      }return ans;
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