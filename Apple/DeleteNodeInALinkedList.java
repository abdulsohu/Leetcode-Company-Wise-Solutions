/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 * Idea:
 * 
 * Because we cannot access the node before given node, we make the given node
 * act like it is its own next node, by taking on the value of its next. And, to
 * finalize this disguise, we say that the node's next node is the next of the
 * node that it is taking over.
 * 
 * So in a way, in the linkedlist [1 -> 2 -> 3 -> 4 -> 5], if you were asked to
 * delete 3, it would go as follows:
 * 
 * 1) Given node will take on the value of its next: [1 -> 2 -> 4 -> 4 -> 5]
 * 
 * 2) Given node will make its next jump over one place:
 * 
 * [1 -> 2 -> 4] {-> 4 (excluded)} [-> 5]
 * 
 * 3) Finally: [1 -> 2 -> 4 -> 5]
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
