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
        if (head == null || head.next == null) return null;

        ListNode temp = head;
        int length = 0;

        while (temp != null){
            length++;
            temp = temp.next;
        }

        temp = head;
        int pos = length - n;

        if (pos == 0)
            return head.next;
            
        for (int i=1; i<pos; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
