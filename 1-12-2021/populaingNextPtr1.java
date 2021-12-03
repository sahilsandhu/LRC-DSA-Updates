/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node black = root;
        while(black!=null && black.left!=null )
        {
            Node level = black;
            while(true)
            {
                level.left.next = level.right;
                if(level.next==null)
                    break;
                level.right.next = level.next.left;
                level = level.next;
            }
            black = black.left;
        }
        return root;
    }
}