import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode node)
    {
        if(node == null || node.next == null)
        return node;
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

    public static void unfold(ListNode head) {
        if(head == null || head.next == null)
        return ;
        
        ListNode odd = head.next,even = head;
        ListNode c1= head, c2 = head.next;
        
        while(c2!=null && c2.next !=null)
        {
            ListNode temp1 = c1.next.next;
            ListNode temp2 = c2.next.next;
            c1.next = temp1;
            c2.next = temp2;
            c1 = temp1;
            c2 = temp2;
            
        }
        ListNode newH = reverse(odd);
        c1.next =  newH;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
