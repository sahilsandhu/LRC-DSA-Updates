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
    public ListNode midNode(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode merge2list(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2== null)
            return l1;
        ListNode dummy = null,prev =null;
        while(l1!=null && l2!= null)
        {
            if(l1.val < l2.val){
                if(dummy == null)
                {
                dummy = l1;
                prev = dummy;
                } 
                else
                {
                prev.next = l1;
                prev = prev.next;
                }
                l1 = l1.next;
            }
            else
            {
                if(dummy == null)
                {
                   dummy = l2; 
                    prev = dummy;
                }
                else{
                    prev.next = l2;
                    prev = prev.next;
                }
                l2 = l2.next;
            }
        }
        if(l1!=null)
        {
           prev.next =  l1;
        }
        else if(l2!=null)
        {
            prev.next = l2;
        }
        return dummy;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(nHead);
        return merge2list(l1,l2);
    }
}