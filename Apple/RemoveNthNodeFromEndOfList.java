/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Idea:
 * 
 * Move a dummy node `t` n steps into the list first. Then, have the node to be
 * removed `removed` walk with `t` and when `t` is beyond the list, you know you
 * must be at the node to be removed.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t = head;
        ListNode removed = head;

        while (n > 0) {
            t = t.next;
            n--;
        }

        if (t == null) {
            head = head.next;
            return head;
        }

        ListNode prev = null;
        while (t != null) {
            if (t.next == null) {
                prev = removed;
            }
            removed = removed.next;
            t = t.next;
        }

        if (prev != null) {
            prev.next = removed.next;
            removed.next = null;
        }

        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
