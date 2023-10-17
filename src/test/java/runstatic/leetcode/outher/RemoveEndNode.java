package runstatic.leetcode.outher;

import org.testng.annotations.Test;
import runstatic.leetcode.entity.ListNode;
import runstatic.leetcode.util.ListNodeUtil;

/**
 * @author chenmoand
 * @date 2023/10/17 20:23
 */
public class RemoveEndNode {

    @Test
    public void testCase() {
        System.out.println(remove(ListNodeUtil.parse("1,2,3,4,5"), 1));
    }

    public ListNode remove(ListNode node, int endInd) {
        assert node != null;

        ListNode root = node;
        ListNode p1 = root, p2 = null, p3 = null;
        int i = 1;
        while (root != null) {
            if(i > endInd) {
                p3 = p1;
                p1 = p1.next;
                p2 = root;
            }
            ++i;
            root = root.next;
        }
        if(p2 != null) {
            p3.next = p1.next;
        } else {
            return node.next;
        }

        return node;
    }

}
