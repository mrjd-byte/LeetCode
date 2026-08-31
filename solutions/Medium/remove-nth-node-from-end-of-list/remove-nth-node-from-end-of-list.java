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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null || head == null)
            return null;

        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (count == n)
            return head.next;

        int i = count - n;

        ListNode temp2 = head;
        int cnt2 = 1;
        while (cnt2 < i) {
            temp2 = temp2.next;
            cnt2++;
        }
        temp2.next = temp2.next.next;

        return head;

    }
}