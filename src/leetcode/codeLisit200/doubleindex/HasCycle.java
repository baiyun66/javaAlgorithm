package leetcode.codeLisit200.doubleindex;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while(p.next!=null &&q.next!=null && q.next.next!=null){
            if(p.next == q.next.next){
                return true;
            }
            p = p.next;
            q = q.next.next;
        }

        return false;
    }
    public static void main(String[] args) {

    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
      }
 }

