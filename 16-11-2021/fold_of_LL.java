import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode findMid(ListNode head)
    {
    if(head == null || head.next == null)
        return head;
        
     ListNode slow = head;
     ListNode fast = head;
     while(fast.next!=null && fast.next.next!=null)
     {
         fast = fast.next.next;
         slow = slow.next;
     }
     return slow;
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

    public static void fold(ListNode head) {
        if(head == null && head.next==null)
            return;
        ListNode mid = findMid(head);
        
        ListNode firstH = head;
        ListNode secondH = mid.next;
        mid.next= null;
        
        secondH = reverse(secondH);
        
        ListNode c1 = firstH;
        ListNode c2 = secondH;
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
        fold(head);
        printList(head);
    }
}