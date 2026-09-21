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
        ListNode temp = head;
        int N = 0;
        while (temp != null){
            temp = temp.next;
            N++;
        }

        int remove = N - n;
        if (remove == 0){
            return head.next;
        }

        temp = head;
        for (int i=0; i<N-1; i++){
            if ((i + 1) == remove){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
