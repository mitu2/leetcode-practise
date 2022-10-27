package runstatic.leetcode.i21_30;

import runstatic.leetcode.entity.ListNode;

/**
 * @author chenmoand
 */
public class SwapNodesInPairs_24 {

    /**
     * 简单
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode next = head.next, nextTwo;
        if (next != null) {
            nextTwo = next.next;
            next.next = head;
            head.next =  swapPairs(nextTwo);
        } else {
            return head;
        }
        return next;
    }

}
