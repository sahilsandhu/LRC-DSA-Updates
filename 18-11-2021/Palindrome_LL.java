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
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
    public ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode nex = null;
        ListNode  curr = node;
        while(curr!=null)
        {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode mid = findMid(head);
        ListNode secH = mid.next;
        ListNode firH = head;
        mid.next = null;
        secH = reverse(secH);
        while(secH!=null && firH!=null)
        {
            if(secH.val != firH.val)
            {
                return false;
            }
            firH = firH.next;
            secH = secH.next;
        }
    return true;
    }
    
}
