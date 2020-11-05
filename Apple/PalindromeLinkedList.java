
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
