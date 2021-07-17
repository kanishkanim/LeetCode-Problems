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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr = head;
        ListNode next;
        if (curr != null) { 
            next = head.next; 
        } else { 
            next = null; 
        }
        
        while (next != null) {
                
            if (curr.val == next.val) {
                curr.next = next.next;
                next = next.next;
            }
            
            else {
                curr = next;
                next = curr.next;
            }
        }
        
        return head; 
    }
}