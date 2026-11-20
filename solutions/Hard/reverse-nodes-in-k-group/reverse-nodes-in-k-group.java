/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode current = head;

        while (current != null) {
            Stack<ListNode> st = new Stack<>();
            int count = 0;

            ListNode groupStart = current;

            while (current != null && count < k) {
                st.push(current);
                current = current.next;
                count++;
            }

            if (count == k) {
                while (!st.isEmpty()) {
                    tail.next = st.peek();
                    st.pop();
                    tail = tail.next;
                }
            } else {
                while (groupStart != null) {
                    ListNode nextNode = groupStart.next;
                    tail.next = groupStart;
                    tail = tail.next;
                    groupStart = nextNode;
                }
                break;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}