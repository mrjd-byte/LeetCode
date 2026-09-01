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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        ListNode temp = head;

        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        // temp.next = head;
        // System.out.println(count);

        k = k % count;
        if (k == 0) {
            return head;
        }

        int num = count - k;
        int cnt = 1;
        ListNode temp2 = head;

        while (cnt != num) {
            cnt++;
            temp2 = temp2.next;
        }

        ListNode newHead = temp2.next;
        temp2.next = null;
        temp.next = head;
        return newHead;

    }
}