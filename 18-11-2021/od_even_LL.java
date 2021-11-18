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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddP = new ListNode(-1);
        ListNode evenP = new ListNode(-1);
        ListNode odd = oddP;
        ListNode even = evenP;
        boolean flag = true;
        while(head!=null)
        {
            if(flag == true)
            {
                even.next = head;
                even = even.next;
                flag = false;
            }
            else
            {
                odd.next = head;
                odd = odd.next;
                flag = true;
            }
            head = head.next;
        }
      even.next = oddP.next;
        odd.next = null;
        return evenP.next;
    }
}