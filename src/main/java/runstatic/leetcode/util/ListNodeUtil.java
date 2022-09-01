package runstatic.leetcode.util;

import runstatic.leetcode.entity.ListNode;

/**
 * @author chenmoand
 */
public class ListNodeUtil {

    public static ListNode parse(String str) {
        ListNode root = null, cur = null;
        String[] split = str.split("[,，]");

        for (String s : split) {
            s = s.trim();
            if (root == null) {
                cur = root = new ListNode(Integer.parseInt(s));
            } else {
                cur = cur.next = new ListNode(Integer.parseInt(s));
            }
        }

        return root;
    }

}
