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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode list : lists){
            if (list != null)
                heap.offer(list);
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (!heap.isEmpty()){
            ListNode curr = heap.poll();
            temp.next = curr;
            temp = temp.next;

            if (curr.next != null)
                heap.offer(curr.next);
        }

        return dummy.next;
    }
}
