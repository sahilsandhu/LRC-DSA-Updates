/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int size(ListNode node)
    {
        int count = 0;
        while(node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }
    public  ListNode th = null;
    public  ListNode tt = null;
    
    public  void addFirst(ListNode node)
    {
        if(th == null)
        {
            th = node;
            tt = node;
        }
        else
        {
            node.next = th;
            th = node;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
        return head;
    int len = size(head);
    ListNode oh = null;
    ListNode ot = null;
    ListNode curr = head;
    while(len >= k)
    {
        int temp = k;
        while(temp-- >0)
        {
            ListNode nex = curr.next;
            curr.next = null;
            addFirst(curr);
            curr = nex;
        }
        if(oh == null)
        {
           oh = th;
           ot = tt;
        }else
        {
            ot.next = th;
            ot = tt;
        }
        th = null;
        tt = null;
        len-=k;
    }
    ot.next = curr;
        
        return oh;
    }
}