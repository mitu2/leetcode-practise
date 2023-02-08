package runstatic.leetcode.outher;

import org.testng.annotations.Test;
import runstatic.leetcode.entity.ListNode;
import runstatic.leetcode.util.ListNodeUtil;

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


    public ListNode reverseList2(ListNode root) {
        ListNode cur = root;
        ListNode nx = cur.next;
        cur.next = null;
        while (nx != null) {
            ListNode next = nx.next;
            nx.next = cur;
            cur = nx;
            nx = next;
        }


        return cur;
    }

    @Test
    public void testCase() {
        System.out.println(reverseList2(ListNodeUtil.parse("1,2,3,4,5")));
    }

}
