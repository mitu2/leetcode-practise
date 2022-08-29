package runstatic.leetcode.i1_10;

import com.google.gson.Gson;
import runstatic.leetcode.entity.ListNode;

/**
 * @author chenmoand
 */
public class AddTwoNumbers_2 {


    /**
     * 此方法会超出上限
     * @param l1
     * @param l2
     * @return
     */
    @Deprecated
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long i = 0L, count = 0L;
        while (l1 != null || l2 != null) {
            i = i == 0 ? 1 : i * 10;
            if (l1 != null) {
                count += l1.val * i;
                l1 = l1.next;
            }
            if (l2 != null) {
                count += l2.val * i;
                l2 = l2.next;
            }
        }

        if (count == 0) {
            return new ListNode(0);
        }

//        count = 1000000000000000000000000000466L;

        ListNode result = null, root = null;

        // System.out.println(count);
        long j = 1L;

        while (count >= j) {
            if (root == null) {
                result = root = new ListNode((int) ((count / j) % 10));
            } else {
                root = root.next = new ListNode((int) ((count / j) % 10));
            }
            j *= 10;
        }

        return result;
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode result = null, root = null;
        int isUp = 0;
        while (l1 != null || l2 != null) {
            int i1 = 0, i2 = 0;
            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }

//            System.out.print(i1 + " ");
//            System.out.println(i2);

            int count = i1 + i2 + isUp;
            if (count >= 10) {
                count = count - 10;
                isUp = 1;
            } else {
                isUp = 0;
            }

            if (result == null) {
                result = root = new ListNode(count);
            } else {
                root = root.next = new ListNode(count);
            }
        }
        if (isUp == 1) {
            root.next = new ListNode(1);
        }
        return result;
    }


    public static void main(String[] args) {
        AddTwoNumbers_2 instance = new AddTwoNumbers_2();
        Gson gson = new Gson();
        ListNode result = instance.addTwoNumbersV2(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        );
        ListNode result2 = instance.addTwoNumbers(
                new ListNode(9),
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))))
        );
        System.out.println(gson.toJson(result));
        System.out.println(gson.toJson(result2));
    }

}
