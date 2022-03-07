package leetcode.codeLisit200.LinkList;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next_node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next_node;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
