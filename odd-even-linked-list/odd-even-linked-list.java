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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return head;
        
        int oddEvenIndicator = 1;
        ListNode lastOddNode = head;
        ListNode firstEvenNode = head.next;
        ListNode lastEvenNode = head.next;
        ListNode currentNode = head.next.next;
        
        while(currentNode != null){
            if(oddEvenIndicator % 2 == 0){
                lastEvenNode.next = currentNode;
                lastEvenNode = currentNode;
            }else{
                lastOddNode.next = currentNode;
                lastOddNode = currentNode;
            }
            currentNode = currentNode.next;
            oddEvenIndicator++;
        }
        
        lastOddNode.next = firstEvenNode;
        lastEvenNode.next = null;
        return head;
    }
}