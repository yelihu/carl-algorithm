package org.example.algo.day3_linkedlist_2;

import org.example.algo.ds.ListNode;

/**
 * @author yelihu
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode pre = fast;
                ListNode post = head;
                while (pre != post) {
                    pre = pre.next;
                    post = post.next;
                }
                return post;
            }
        }
        return null;
    }
}
