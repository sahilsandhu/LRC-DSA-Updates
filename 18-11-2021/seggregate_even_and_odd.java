import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode evenh = new ListNode(-1);
        ListNode oddh = new ListNode(-1);
        ListNode even= evenh, odd = oddh, curr =head;
        while(curr!=null)
        {
            if(curr.val%2 == 0)
            {
               even.next = curr;
               even = even.next;
            }
            else
            {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }
        even.next = oddh.next;
        odd.next =  null;
        return evenh.next;
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}