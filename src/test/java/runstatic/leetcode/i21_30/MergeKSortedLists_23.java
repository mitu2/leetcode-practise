package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;
import runstatic.leetcode.entity.ListNode;
import runstatic.leetcode.util.ListNodeUtil;

import java.util.Arrays;

/**
 * @author chenmoand
 */
public class MergeKSortedLists_23 {

    @TODO("性能渣渣")
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null, cur = null;
        ListNode minNode = null;
        int minIndex = 0;
        while (true) {
            minNode = null;
            minIndex = 0;
            loop: for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    continue loop;
                }
                if (minNode == null) {
                    minNode = node;
                    minIndex = i;
                } else {
                    if (node.val < minNode.val) {
                        minNode = node;
                        minIndex = i;
                    }
                }
            }
            if (minNode == null) {
                return root;
            }
            if (root == null) {
                cur = root = new ListNode(minNode.val);
            } else {
                cur = cur.next = new ListNode(minNode.val);
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
