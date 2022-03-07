package leetcode.codeLisit200.LinkList;

import java.util.HashSet;
import java.util.Set;

public class getIntersectionNode {
    public ListNode get(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        Set<ListNode> set = new HashSet<>();
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }

        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            } else {
                p2 = p2.next;
            }
        }

        return null;

    }

    public ListNode get2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 !=  p2 ) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        return p1;
    }

}

//Definition for singly-linked list.
final class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}