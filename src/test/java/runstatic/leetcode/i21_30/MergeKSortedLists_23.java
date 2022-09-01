package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;
import runstatic.leetcode.entity.ListNode;
import runstatic.leetcode.util.ListNodeUtil;


/**
 * @author chenmoand
 */
public class MergeKSortedLists_23 {

    @TODO("性能渣渣")
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null, cur = null;
        int minIndex = -1;
        while (true) {
            minIndex = -1;
            loop: for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    continue loop;
                }
                if (minIndex == -1) {
                    minIndex = i;
                } else {
                    if (node.val < lists[minIndex].val) {
                        minIndex = i;
                    }
                }
            }
            if (minIndex == -1) {
                return root;
            }
            if (root == null) {
                cur = root = new ListNode(lists[minIndex].val);
            } else {
                cur = cur.next = new ListNode(lists[minIndex].val);
            }
            if(lists[minIndex] != null) {
                lists[minIndex] = lists[minIndex].next;
            }

        }

    }

    @Test
    public void testMergeKLists() {
        ListNode[] listNodes = {
                ListNodeUtil.parse("1,4,5"),
                ListNodeUtil.parse("1,3,4"),
                ListNodeUtil.parse("2,6")

        };
        System.out.println(mergeKLists(listNodes));
    }

}
