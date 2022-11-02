package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;
import runstatic.leetcode.entity.ListNode;
import runstatic.leetcode.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmoand
 */
public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup_not(ListNode head, int k) {
        ListNode[] caches = new ListNode[k];
        int ind = 0;
        ListNode node = head;
        ListNode result = null, cur = null;
        while (node != null) {
            caches[ind] = node;
            ListNode next = node.next;
            if (ind == k - 1) {
                for (int i = caches.length - 1; i >= 0; i--) {
                    if (result == null) {
                        result = cur = caches[i];
                    } else {
                        cur.next = caches[i];
                        cur = cur.next;
                    }
                }
                ind = 0;
            }

            node = next;
            ++ind;
        }

        for (int i = 0; i >= ind; i--) {
            if (result == null) {
                result = caches[i];
                cur = result;
            } else {
                cur.next = caches[i];
                cur = cur.next;
            }
        }
        if (cur != null) {
            cur.next = null;
        }

        return result;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode root = head;
        while (root != null) {
            list.add(root);
            root = root.next;
        }
        int size = list.size();
        if (size < k) {
            return head;
        }
        ListNode result = null, cur = null;
        int start = 0;
        for (; start + k <= size; start += k) {
            for (int i = start + k - 1; i >= start; i--) {
                ListNode listNode = list.get(i);
                // System.out.println(start + " __ " + i);
                if (result == null) {
                    cur = result = listNode;
                } else {
                    cur = cur.next = listNode;
                }
            }
        }

        for (; start < size; ++start) {
            ListNode listNode = list.get(start);
            if (result == null) {
                cur = result = listNode;
            } else {
                cur = cur.next = listNode;
            }
        }

        if(cur != null) {
            cur.next = null;
        }

        return result;

    }


    @Test
    public void testReverseKGroup() {
        System.out.println(reverseKGroup(ListNodeUtil.parse("1,2"), 2));
    }

}
