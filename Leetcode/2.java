/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carryOver = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (curr1 != null || curr2 != null) {
            int firstNum = (curr1 == null) ? 0 : curr1.val;
            int secondNum = (curr2 == null) ? 0 : curr2.val;
            int sum = firstNum + secondNum + carryOver;
            carryOver = sum / 10;
            temp.next = new ListNode(sum - carryOver * 10);
            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
            temp = temp.next;
        }

        if (carryOver == 1) {
            temp.next = new ListNode(1);
        }
        return dummy.next;

    }
}