package runstatic.leetcode.i21_30;

import org.testng.Assert;
import org.testng.annotations.Test;
import runstatic.leetcode.annotation.Wrong;
import runstatic.leetcode.entity.ListNode;

/**
 * @author chenmoand
 */
public class MergeTwoSortedLists_21 {

    @Wrong("这个复用传入的的list1和list2中的ListNode反而运行更慢了")
    @Deprecated
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root1 = list1, root2 = list2;
        ListNode result = null, cur = null;
        while (true) {
//            System.out.println("cur: " +  cur);
//            System.out.println(result);
//            System.out.printf("list1 %s list2 %s%n", root1, root2);
            boolean isNull1 = root1 == null;
            boolean isNull2 = root2 == null;
//            System.out.printf("%s %s %n", isNull1, isNull1);
            if (isNull1 && isNull2) {
                System.out.println(result);
                if (cur != null) {
                    cur.next = null;
                }
                return result;
            } else if (!isNull1 && !isNull2) {
                if (root1.val < root2.val) {
                    if (result == null) {
                        result = cur = new ListNode(root1.val);
                    } else {
                        cur = cur.next = root1;
                    }
                    root1 = root1.next;
                } else {
                    if (result == null) {
                        result = cur = new ListNode(root2.val);
                    } else {
                        cur = cur.next = root2;
                    }
                    root2 = root2.next;
                }
                continue;
            }
            if (!isNull1) {
                if (result == null) {
                    result = cur = new ListNode(root1.val);
                } else {
                    cur = cur.next = root1;
                }
                root1 = root1.next;
                continue;
            }
            if (result == null) {
                result = cur = new ListNode(root2.val);
            } else {
                cur = cur.next = root2;
            }
            root2 = root2.next;
        }
    }

    public ListNode mergeTwoLists_v2(ListNode list1, ListNode list2) {
        ListNode root1 = list1, root2 = list2;
        ListNode result = null, cur = null;
        while (true) {
//            System.out.printf("list1 %s list2 %s%n", root1, root2);
            boolean isNull1 = root1 == null;
            boolean isNull2 = root2 == null;
//            System.out.printf("%s %s %n", isNull1, isNull1);
            if (isNull1 && isNull2) {
                return result;
            }
            if (!isNull1 && !isNull2) {
                if (root1.val < root2.val) {
                    if (cur == null) {
                        result = cur = new ListNode(root1.val);
                    } else {
                        cur = cur.next = new ListNode(root1.val);
                    }
                    root1 = root1.next;
                } else {
                    if (cur == null) {
                        result = cur = new ListNode(root2.val);
                    } else {
                        cur = cur.next = new ListNode(root2.val);
                    }
                    root2 = root2.next;
                }
                continue;
            }
            if (!isNull1) {
                if (cur == null) {
                    result = cur = new ListNode(root1.val);
                } else {
                    cur = cur.next = new ListNode(root1.val);
                }
                root1 = root1.next;
                continue;
            }
            if (cur == null) {
                result = cur = new ListNode(root2.val);
            } else {
                cur = cur.next = new ListNode(root2.val);
            }
            root2 = root2.next;
        }
    }

    public ListNode mergeTwoLists_v3(ListNode list1, ListNode list2) {
        ListNode root1 = list1, root2 = list2;
        ListNode result = null, cur = null;
        while (root1 != null && root2 != null) {
            if (root1.val < root2.val) {
                if (cur == null) {
                    result = cur = new ListNode(root1.val);
                } else {
                    cur = cur.next = new ListNode(root1.val);
                }
                root1 = root1.next;
            } else {
                if (cur == null) {
                    result = cur = new ListNode(root2.val);
                } else {
                    cur = cur.next = new ListNode(root2.val);
                }
                root2 = root2.next;
            }
        }

        while (root1 != null) {
            if (cur == null) {
                result = cur = new ListNode(root1.val);
            } else {
                cur = cur.next = new ListNode(root1.val);
            }
            root1 = root1.next;
        }

        while (root2 != null) {
            if (cur == null) {
                result = cur = new ListNode(root2.val);
            } else {
                cur = cur.next = new ListNode(root2.val);
            }
            root2 = root2.next;
        }

        return result;
    }


    @Test
    public void testMergeTwoLists() {
        ListNode listNode = mergeTwoLists_v2(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
        );
        Assert.assertEquals(listNode.toString(), "1,1,2,3,4,4");
    }

    @Test
    public void testV3MergeTwoLists() {
        ListNode listNode = mergeTwoLists_v3(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
        );
        Assert.assertEquals(listNode.toString(), "1,1,2,3,4,4");
    }


}
