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
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        //Compute the length of LL
        ListNode curr = head;
        int len = 1;
        while(curr.next != null){
            len++;
            curr = curr.next;
        }
        
        //Go till that node
        curr.next = head;
        k = len - k % len;
        while(k-- > 0) curr = curr.next;
        
        //Make node head & break the connection
        head = curr.next;
        curr.next = null;
        return head;
    }
}