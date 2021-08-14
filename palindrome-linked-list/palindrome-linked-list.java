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
    
    public static ListNode midNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = null;
        
        while(curr != null){
            forw = curr.next; //backup
            curr.next = prev; //link
            
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode mid = midNode(head);
        ListNode newHead = mid.next;
        mid.next = null;
        
        newHead = reverseLL(newHead);
        
        ListNode c1 = head;
        ListNode c2 = newHead;
        
        boolean res = true;
        while(c2 != null){ //we do a check for only c2 as it handles the case for odd LL
            
            if(c1.val != c2.val){
                res = false;
                break;   
            }
            
            c1 = c1.next;
            c2 = c2.next;
        }
        
        newHead = reverseLL(newHead);
        mid.next = newHead;
        
        return res;
    }
}