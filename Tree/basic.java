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

// construct BST from inorder

public static int idx = 0;
    public static TreeNode constructFromInOrder_(int[] inorder,int si,int ei)
    {
        if(si >= ei)
        {
            return si==ei?new TreeNode(inorder[si]) : null;
        }
        int mid = (si + ei)/2;
        TreeNode node = new TreeNode(inorder[mid]);
        node.left = constructFromInOrder_(inorder,si,mid-1);
        node.right = constructFromInOrder_(inorder,mid+1,ei);
        return node;
        
    }
    public static TreeNode constructFromInOrder(int[] inorder) {
        idx = 0;
        return constructFromInOrder_(inorder,0,inorder.length-1);
    }
// construct bst from postorder
class GFG
{
    public static int idx;
    public static Node bstFromPostorder_(int[] postorder,int min,int max)
    {
        if(idx < 0 || postorder[idx] < min  || postorder[idx] > max)
        return null;
        Node node = new Node(postorder[idx--]);
        node.right = bstFromPostorder_(postorder,node.data,max);
        node.left = bstFromPostorder_(postorder,min,node.data);
        return node;
    }
    public static Node constructTree(int[] postorder,int n) {
        idx = postorder.length-1;
        return bstFromPostorder_(postorder,Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
}

// Construct BT from levelorder traversal

 public static class pair{
        TreeNode node;
        int min;
        int max;
        pair(TreeNode node,int min,int max)
        {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    } 
    public static TreeNode constructBSTFromLevelOrder_(int[] levelorder)
    {
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(null,Integer.MIN_VALUE,Integer.MAX_VALUE));
        int idx = 0;
        TreeNode root = null;
        while(q.size()>0 && idx < levelorder.length)
        {
            pair rp = q.remove();
            if (levelorder[idx] < rp.min || levelorder[idx] > rp.max)continue;
            
            TreeNode node = new TreeNode(levelorder[idx++]);
            if(rp.node == null)
            {
               root = node; 
            }
            else
            {
                //TreeNode node = new TreeNode(levelorder[idx++]);
                if(rp.node.val < node.val)
                {
                    rp.node.right = node;
                }
                else
                {
                    rp.node.left = node;
                }
            }
            q.add(new pair(node,rp.min,node.val));
            q.add(new pair(node,node.val,rp.max));
        }
        return root;
        
    }
    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        return constructBSTFromLevelOrder_(LevelOrder);
    }


// width of a Binary Tree
public static void solve(TreeNode root,int level,int[] wid)
    {
        if(root == null)
        return;
        solve(root.left,level-1,wid);
        solve(root.right,level+1,wid);
        wid[0] = Math.min(wid[0],level);
        wid[1] = Math.max(wid[1],level);
        //return wid[0]-wid[1]+1;
        
    }
    public static int width(TreeNode root) {
       int[] wid= new int[2];
       solve(root,0,wid);
       return wid[1]-wid[0]+1;
    }
    
//  vertical level order Traversal Sum

public static void findWid(TreeNode root,int level,int[] wid)
    {
        if(root == null)
        return;
        findWid(root.left,level-1,wid);
        findWid(root.right,level+1,wid);
        wid[0] = Math.min(wid[0],level);
        wid[1] = Math.max(wid[1],level);
    }
    public static void verticalOrderTraversal_(TreeNode root, int level, HashMap<Integer,Integer> hmap)
    {
        if(root == null)
        return;
        if(!hmap.containsKey(level))
        {
         hmap.put(level,0);   
        }
        int val = hmap.get(level) + root.val;
        hmap.put(level,val);
        verticalOrderTraversal_(root.left,level-1,hmap);
        verticalOrderTraversal_(root.right,level+1,hmap);
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        int[] wid = new int[2];
        findWid(root,0,wid);
        int width = wid[1]-wid[0]+1;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
      verticalOrderTraversal_(root,0,hmap);  
      int si = wid[0], ei = wid[1];
      while(si<=ei)
      {
          ans.add(hmap.get(si++));
      }
      return ans;
    }

// level order traversal
public List<List<Integer>> levelOrder(TreeNode root) {
     Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        q.add(root);
        while(q.size() > 0)
        {
            int s = q.size();
            List<Integer> ar = new ArrayList<>();
            while(s-- > 0)
            {
                TreeNode rn = q.remove();
                ar.add(rn.val);
                if(rn.left != null)
                    q.add(rn.left);
                if(rn.right != null)
                    q.add(rn.right);
            }
            ans.add(ar);
        }
        return ans;
    }

// Left View 

ArrayList<Integer> leftView(Node root)
    {
     Queue<Node> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        q.add(root);
        while(q.size() > 0)
        {
            int s = q.size();
            ArrayList<Integer> ar = new ArrayList<>();
            while(s-- > 0)
            {
                Node rn = q.remove();
                ar.add(rn.data);
                if(rn.left != null)
                    q.add(rn.left);
                if(rn.right != null)
                    q.add(rn.right);
            }
            ans.add(ar.get(0));
        }
        return ans;
    }

// Right View 
ArrayList<Integer> rightView(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        q.add(root);
        while(q.size() > 0)
        {
            int s = q.size();
            ArrayList<Integer> ar = new ArrayList<>();
            while(s-- > 0)
            {
                Node rn = q.remove();
                ar.add(rn.data);
                if(rn.left != null)
                    q.add(rn.left);
                if(rn.right != null)
                    q.add(rn.right);
            }
            ans.add(ar.get(ar.size()-1));
        }
        return ans;
    }

// Vertical order Traversal

 public static class pair{
        TreeNode node;
        int level;
        pair(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
      Queue<pair> q = new LinkedList<>();
      q.add(new pair(root,0));
      HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
      int minhl = 0;
      int maxhl = 0;
      while(q.size() > 0)
      {
        int sz = q.size();
        while(sz-- > 0)
        {
            pair rp = q.remove();
            hmap.putIfAbsent(rp.level,new ArrayList<>());
            hmap.get(rp.level).add(rp.node.val);
            minhl = Math.min(rp.level, minhl);
            maxhl = Math.max(rp.level, maxhl);
            if(rp.node.left != null)
            {
               q.add(new pair(rp.node.left,rp.level-1)); 
            }
            if(rp.node.right != null)
            {
                q.add(new pair(rp.node.right,rp.level+1));
            }
        }
      }
      
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      while(minhl<=maxhl)
      {
        ans.add(hmap.get(minhl++));
      }
      return ans;

    }

    // Diagonal Traversal 1

        public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       Queue<TreeNode> q = new ArrayDeque<>();
       
       q.add(root);
       int idx = 0;
       while(q.size() > 0)
       {
        int sz = q.size();
        ArrayList<Integer> tmp = new ArrayList<>();

           while(sz-- > 0)
           {
               TreeNode rn = q.remove();
               while(rn!=null)
               {
                   if(rn.left != null)
                   {
                       q.add(rn.left);
                   }
                   tmp.add(rn.val);
                   rn = rn.right;
               }
               
           }
           ans.add(tmp);
       }
       return ans;
    }

// Diagonal Traversal 2
public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
       
    q.add(root);
    int idx = 0;
    while(q.size() > 0)
       {
        int sz = q.size();
        ArrayList<Integer> tmp = new ArrayList<>();

           while(sz-- > 0)
           {
               TreeNode rn = q.remove();
               while(rn!=null)
               {
                   tmp.add(rn.val);
                   if(rn.right != null)
                   {
                       q.add(rn.right);
                   }
                   rn = rn.left;
               }
               
           }
           ans.add(tmp);
       }
       return ans;
    }

// Diagonal order sum of BT
// Same

// all single child parent in BT

public static void exactlyOneChild_(TreeNode root,ArrayList<Integer> ans)
  {
    if(root == null || (root.left==null && root.right==null))
    return;
    if((root.left==null && root.right!=null) || (root.right==null && root.left != null))
    {
        ans.add(root.val);
    }
    exactlyOneChild_(root.left,ans);
    exactlyOneChild_(root.right,ans);
    
    return;
  }

//// count all single child parent in BT


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

//burninig tree


// burning tree 2




