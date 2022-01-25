// size, sum, max, height
public static int size(Node node) {
    if(node == null)
    return 0;
    int sz = 0;
    sz += size(node.left);
    sz += size(node.right);
    return sz+1;
  }

  public static int sum(Node node) {
    if(node == null)
    return 0;
    int sm = 0;
    sm += sum(node.left);
    sm += sum(node.right);
    return sm+node.data;
  }

  public static int max(Node node) {
    if(node == null)
    return Integer.MIN_VALUE;
    int mx = Integer.MIN_VALUE;
    mx = Math.max(mx,max(node.left));
    mx = Math.max(mx,max(node.right));
    return Math.max(mx,node.data); 
  }

  public static int height(Node node) {
    if(node == null)
    return -1;
    return Math.max(height(node.left), height(node.right))+1;
    }

// Level order Traversal

  public static void levelOrder(Node node) {
    Queue<Node>q = new ArrayDeque<>();
    q.add(node);
    while(q.size()>0)
    {
        int s = q.size();
        while(s-- > 0)
        {
            Node rn = q.remove();
            System.out.print(rn.data+" ");
            if(rn.left != null)
            q.add(rn.left);
            if(rn.right != null)
            q.add(rn.right);
        }
        System.out.println();
    }
  }

// Iterative Inorder Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class pair{
    TreeNode node;
    boolean ld;
    boolean sd;
    boolean rd;
    pair(TreeNode node,boolean ld,boolean sd,boolean rd)
    {
        this.node = node;
        this.ld = ld;
        this.sd = sd;
        this.rd = rd;
    }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<pair> st = new Stack<>();
        st.push(new pair(root,false,false,false));
        while(st.size() > 0)
        {
            pair rp = st.peek();
            if(rp.ld == false)
            {
                if(rp.node.left!=null)
                    st.push(new pair(rp.node.left,false,false,false));
                rp.ld = true;
            }
            else if(rp.sd == false)
            {
                ans.add(rp.node.val);
                rp.sd = true;
            }
            else if(rp.rd == false)
            {
               if(rp.node.right!=null)
                    st.push(new pair(rp.node.right,false,false,false));
                rp.rd = true; 
            }
            else
            {
                st.pop();
            }
        }
        return ans;
    }
}

// Iterative Preorder Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class pair{
    TreeNode node;
    boolean ld;
    boolean sd;
    boolean rd;
    pair(TreeNode node, boolean ld,boolean sd,boolean rd)
    {
        this.node = node;
        this.ld = ld;
        this.sd = sd;
        this.rd = rd;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<pair> st = new Stack<>();
        if(root == null)
            return ans;
        st.push(new pair(root,false,false,false));
        while(st.size() > 0)
        {
            pair rp = st.peek();
            if(rp.sd == false)
            {
                ans.add(rp.node.val);
                rp.sd = true;
            }
            else if(rp.ld == false)
            {
                if(rp.node.left!=null)
                    st.push(new pair(rp.node.left,false,false,false));
                rp.ld = true;
            }
            
            else if(rp.rd == false)
            {
               if(rp.node.right!=null)
                    st.push(new pair(rp.node.right,false,false,false));
                rp.rd = true; 
            }
            else
            {
                st.pop();
            }
        }
        return ans;
    }
}

// Morris Inorder Traversal
 public TreeNode RightMostNode(TreeNode left,TreeNode curr)
    {
        while(left.right!=null &&left.right != curr)
            left = left.right;
        return left;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        TreeNode curr = root;
        while(curr != null)
        {
            TreeNode left = curr.left;
            if(left == null)
            {
               ans.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode rgtn = RightMostNode(left,curr);
                if(rgtn.right == null)
                {
                    rgtn.right = curr;
                    curr = curr.left;
                }
                else
                {
                    rgtn.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

// Morris PreOrder Traversal

public TreeNode rightMostNode(TreeNode left,TreeNode curr)
    {
        while(left.right != null && left.right != curr)
            left = left.right;
        return left;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        TreeNode curr = root;
        while(curr!=null)
        {
            TreeNode left = curr.left;
            if(left==null)
            {
                ans.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode rhtnode = rightMostNode(left,curr);
                if(rhtnode.right == null)
                {
                 rhtnode.right = curr;
                 ans.add(curr.val);
                 curr = curr.left;
                }
                else
                {
                    rhtnode.left = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

// find in the BT

public static boolean find(Node node, int data){
    if(node == null)
    return false;
    boolean res = false;
    res = res || find(node.left,data);
    res = res || find(node.right,data);
    return res || (node.data == data);
  }

// Node to Root Path 

public static ArrayList<Integer> nodeToRootPath(Node node, int data){
      if(node == null)
      return new ArrayList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      if(node.data == data)
      {
          ans.add(node.data);
          return ans;
      }
      ArrayList<Integer> left = nodeToRootPath(node.left,data);
      if(left.size() > 0)
      {
        left.add(node.data);
        return left;
      }
      ArrayList<Integer> right = nodeToRootPath(node.right,data);
      if(right.size() > 0)
      {
          right.add(node.data);
          return right;
      }
      return ans;
  }

// Print k level Down

public static void printKLevelsDown(Node node, int k){
    if(node == null)
    return;
    if(k==0)
    {
        System.out.println(node.data);
        return;
    }
    printKLevelsDown(node.left,k-1);
    printKLevelsDown(node.right,k-1);
  }

// print k nodes away

public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    List<Node> ntrpath = nodeToRootPath(node,data);
    Node block = null;
    for(int i=0;i<ntrpath.size();i++)
    {
        printKLevelsDown(ntrpath.get(i),k-i,block);
        block = ntrpath.get(i);
        
    }

// path to leaves from root

public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
    // write your code here
    if(node == null)
    return;
    if(node.left == null && node.right == null)
    {
        if(sum+node.data >= lo && sum+node.data <= hi)
        System.out.println(path+node.data);
        return;
    }
    pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
    pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
  }

// Left CLoned Tree

public static Node createLCT(Node node)
  {
      if(node == null)
      return null;
      Node nnode = new Node(node.data,null,null);
      Node left = createLCT(node.left);
      Node right = createLCT(node.right);
      node.left = nnode;
      nnode.left = left;
      node.right = right;
      return node;
  }
  public static Node createLeftCloneTree(Node node){
    return createLCT(node);
  }

// Transform From Left Clonded Tree

public static Node tranformBFLCT(Node node)
  {
      if(node == null || node.left == null)
      return null;
      node.left = tranformBFLCT(node.left.left);
      node.right = tranformBFLCT(node.right);
      return node;
  }
  public static Node transBackFromLeftClonedTree(Node node){
    // write your code here
    return tranformBFLCT(node);
  }

// Print single Child Nodes

 public static void printSingleChildNodes(Node node, Node parent){
    if(node == null)
    return;
    if(parent!= null && ((parent.left == null && parent.right != null)||(parent.left != null && parent.right == null)))
    {
        System.out.println(node.data);
    }
    printSingleChildNodes(node.left,node);
    printSingleChildNodes(node.right,node);
  }

// Remove Leaves In Binary Tree
public static Node removeLeaves(Node node){
    if(node == null)
    return null;
    if(node.left == null && node.right == null)
    return null;
    node.left = removeLeaves(node.left);
    node.right = removeLeaves(node.right);
    return node;
  }

// Tilt of a Binary Tree

static int tilt = 0;
  public static int tilt(Node node){
    if(node == null)
    return 0;
    int lsum = tilt(node.left);
    int rsum = tilt(node.right);
    tilt += Math.abs(lsum - rsum);
    return lsum + rsum + node.data;
  }

// Diameter of a Binary Tree

public static int diameter1(Node node) {
    if(node == null)
    return 0;
    int dia1 = diameter1(node.left);
    int dia2 = diameter1(node.right);
    int h = height(node.left) + height(node.right) + 2;
    return Math.max(dia1,Math.max(dia2,h));
  }

// using static
public static int dia=0;
    public int helper(TreeNode root){
        if(root == null)
            return -1;
        int lh = helper(root.left);
        int rh = helper(root.right);
        int th = Math.max(lh,rh)+1;
        if(lh+rh+2 > dia)
            dia = lh+rh+2;
        return th;
    }
    public int diameterOfBinaryTree(TreeNode root) {
      dia = 0;
      helper(root);
        return dia;
    }

// is bst 
class Solution {
    public boolean isValidBST_(TreeNode node,long min, long max){
        if(node == null)
            return true;
        
        boolean res = isValidBST_(node.left,min,node.val);
        boolean res2 = isValidBST_(node.right,node.val,max);
        if(node.val > min && node.val < max && res && res2)
            return true;
        else
            return false;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root,-(long)1e19, (long)1e19);
    }
}

// Largest bst subtree

public static class pair{
        int min,max,size;
        pair(int min,int m,int size)
        {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    public static pair largestBst_(Node root)
    {
        if(root == null)
        {
            return new pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        pair lp = largestBst_(root.left);
        pair rp = largestBst_(root.right);
       
        if(lp.max < root.data && root.data < rp.min){
            return new pair(Math.min(root.data,lp.min),Math.max(root.data,rp.max),lp.size+rp.size+1);
        }
    return new pair(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(lp.size,rp.size));

    }
    static int largestBst(Node root)
    {
      return largestBst_(root).size;
    }

//  camera in BT

 public static int camera = 0;
    public int minCameraCover_(TreeNode root)
    {
        if(root == null)
            return 0;
        int ls = minCameraCover_(root.left);
        int rs = minCameraCover_(root.right);
        if(ls == -1 || rs == -1)
        {
            camera++;
            return 1;
        }
        if(ls==1 || rs == 1)
            return 0;
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        camera = 0;
        if(minCameraCover_(root) == -1)
            camera++;
        return camera;
    }

// Recover BST
class Solution {
    public TreeNode predecessor(TreeNode root,TreeNode curr)
    {
        while(root.right != null && root.right != curr)
            root = root.right;
        return root;
    }
    public TreeNode recoverTree_(TreeNode root)
    {
        TreeNode curr = root;
        TreeNode a = null,b = null;
        TreeNode prev = null;
        while(curr != null)
        {
            TreeNode left = curr.left;
            if(left == null)
            {
                if(prev!= null && prev.val > curr.val)
                {
                if(a == null)
                    a = prev;
                b = curr;}
                prev = curr;
                curr = curr.right;
            }
            else
            {
                TreeNode node = predecessor(curr.left,curr);
                if(node.right == null)
                {
                    node.right = curr;
                    curr = curr.left;
                    
                }
                else
                {
                  node.right = null;
                  // add to list
                if(prev.val > curr.val)
                {
                if(a == null)
                    a = prev;
                b = curr;}
                prev = curr;
                  curr = curr.right;
                  
                }
            }
        }
        if(a!=null)
        {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
        return root;
    }
    public void recoverTree(TreeNode root) {
         recoverTree_(root);
    }
}
// Construct BT from  preorder and inorder 

class Solution {
    public TreeNode buildTree_(int[] preorder,int[] inorder,int ps,int pe,int is,int ie){
        if(ps>pe)
        return null;
        TreeNode node = new TreeNode(preorder[ps]);
        int idx = is;
        while(inorder[idx] != preorder[ps])
        idx++;
        
        int count = idx - is;
        node.left = buildTree_(preorder,inorder,ps+1,ps+count,is,count-1);
        node.right = buildTree_(preorder,inorder,ps+count+1,pe,idx+1,ie);
        return node;
        
    } 
    public TreeNode buildTree(int[] preorder, int[] inorder)     {
       
        return buildTree_(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
}

// construct BT from inorder and postorder

class Solution {
    public  TreeNode buildTree_(int[] inorder,int is,int ie,int[] postorder,int ps,int pe)
    {
        if(ps>pe)
        {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pe]);
        int idx = is;
        while(inorder[idx] != postorder[pe])
        idx++;
        int count = idx-is;
        node.left = buildTree_(inorder,is,idx-1,postorder,ps,ps+count-1);
        node.right = buildTree_(inorder,idx+1,ie,postorder,ps+count,pe-1);
        return node;
    }

    public  TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree_(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}

// construct BT from preorder and postorder

class Solution {
     public  TreeNode constructFromPrePost_(int[]preorder,int[]postorder,int pes,int pee,int pos,int poe)
    {
        if(pes > pee)
        return null;
        TreeNode node = new TreeNode(preorder[pes]);
        if(pes == pee)
        return node;
        int idx = pos;
        while(postorder[idx]!=preorder[pes+1])
        idx++;
        int count = idx-pos+1;
        node.left = constructFromPrePost_(preorder,postorder,pes+1,pes+count,pos,idx);
        node.right = constructFromPrePost_(preorder,postorder,pes+count+1,pee,idx+1,pos);
        return node;
        
    }
    public  TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost_(pre,post,0,pre.length-1,0,post.length);
    }
}

// construct BT from inorder and levelorder

 public static TreeNode buildTree_(int[] inorder,int[] levelorder,int si,int ei)
  {
      if(si > ei)
      return null;
      
      TreeNode node = new TreeNode(levelorder[0]);
      
      HashSet<Integer> set = new HashSet<>();
      int idx = si;
      
      while(inorder[idx] != levelorder[0])
      idx++;
      
      for(int i=si;i<idx;i++)
      set.add(inorder[i]);
      
      int n = ei-si+1;
      int[] left = new int[set.size()];
      int[] right = new int[n - set.size()];
      int li=0,ri=0;
      for(int i=1;i<levelorder.length;i++)
      {
          if(set.contains(levelorder[i]))
          left[li++] = levelorder[i];
          else
          right[ri++] = levelorder[i];
      }
      node.left = buildTree_(inorder,left,si,idx-1);
      node.right = buildTree_(inorder,right,idx+1,ei);
      return node;
  }