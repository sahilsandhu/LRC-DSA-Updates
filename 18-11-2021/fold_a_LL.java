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
    public ListNode findMid(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast !=null && fast.next !=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
        }
        return slow;
    }
    public ListNode reverse(ListNode node)
    {
        
        ListNode curr = node;
        ListNode prev = null;
        ListNode nex = null;
        while(curr!=null)
        {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next==null)
            return ;
        //finding mid
        ListNode mid = findMid(head);
        
        ListNode firH = head;
        ListNode secH = mid.next;
        mid.next = null;
        
        //reverse
        secH = reverse(secH);
        
       // head = firH;
        ListNode c1 = firH;
        ListNode c2 = secH;
        ListNode f1 = null;
        ListNode f2 = null;
        while(c1!=null && c2!=null)
        {
            f1 = c1.next;
            f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
        
    }
    
}