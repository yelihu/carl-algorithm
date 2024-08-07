package org.example.algo.day3_linkedlist_2;

import org.example.algo.ds.ListNode;

/**
 * @author yelihu
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = countListLen(headA);
        int countB = countListLen(headB);
        ListNode fast, slow;
        int diff = countA - countB;
        if (diff > 0) {
            fast = headA;
            slow = headB;
        } else {
            fast = headB;
            slow = headA;
        }

        for (int i = 0; i < Math.abs(diff); i++) {
            fast = fast.next;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }

    private int countListLen(ListNode headA) {
        int count = 0;
        ListNode p = headA;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }


    public static void main(String[] args) {
    //    intersectVal =
        //8
        //listA =
        //[4,1,8,4,5]
        //listB =
        //[5,0,1,8,4,5]

        ListNode headA = new ListNode(4);
        ListNode next = new ListNode(1);
        ListNode next3 = new ListNode(8);
        ListNode next1 = new ListNode(4);
        ListNode next2 = new ListNode(5);

        headA.next = next;
        headA.next.next = next3;
        headA.next.next.next = next1;
        headA.next.next.next.next = next2;

        ListNode headB = new ListNode(6);
        headB.next = new ListNode(0);
        headB.next.next = next;
        headB.next.next.next = next3;
        headB.next.next.next.next = next1;
        headB.next.next.next.next.next = next2;

        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode result = getIntersectionNode.getIntersectionNode(headA, headB);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
