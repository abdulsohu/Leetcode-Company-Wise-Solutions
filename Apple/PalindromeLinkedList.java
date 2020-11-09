
/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Idea:
 * 
 * Easiest solution would be to push all values onto a stack and then iterate
 * through the list removing these stack elements. If you happen to find an
 * element that doesn't match, then it must not be a palindrome.
 */
import java.util.ArrayDeque;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        while (head != null) {
            int curr = stack.pop();
            if (curr != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }

        return true;
    }

    /**
     * Following method does not require extra space, because it essentially
     * reverses the latter half of the list, and then iterates through the first
     * half as well as the second half and if it finds a discrepancy, it returns
     * false!
     */
    public boolean isPalindromeNoExtraSpace(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = reverse(slow);
        ListNode temp1 = head;

        while (temp1 != null && temp != null) {
            if (temp1.val != temp.val)
                return false;
            temp = temp.next;
            temp1 = temp1.next;
        }
        return true;
    }

    public ListNode reverse(ListNode temp) {
        ListNode prev = null;
        ListNode curr = temp;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
