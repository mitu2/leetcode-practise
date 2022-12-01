package runstatic.leetcode.outher;

import runstatic.leetcode.entity.ListNode;

/**
 * @author chenmoand
 */
public class NodeReverseList {

    public ListNode ReverseList(ListNode head) {
        ListNode root = head;
        ListNode result = null;
        while (root != null) {
            ListNode cur = new ListNode();
            cur.val = root.val;
            if(result == null) {
                result = cur;
            } else {
                cur.next = result;
                result = cur;
            }
            root = root.next;
        }
        return result;
    }

}
