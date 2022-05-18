package runstatic.leetcode.i1_10;

import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

/**
 * @author chenmoand
 */
public class ReverseInteger_7 {

    public int reverse_v1(int x) {
        String s = String.valueOf(x);
        boolean bg = s.startsWith("-");
        if(bg) {
            s = s.substring(1);
        }
        try {
            return Integer.parseInt((bg ? "-" : "") + new StringBuilder(s).reverse());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        return result == (int) result ? (int) result : 0;
    }

    @Test
    public void doTest() {
        System.out.println(Integer.parseInt("-321"));
//        int i = 9646324351;
        System.out.println(reverse(-2147483648));
    }

    @Test
    public void doTest2() {
        System.out.println(reverse_v1(-123));
//        System.out.println(~200);
//        System.out.println(11 ^ 21);
//        System.out.println(32 ^ 70);
//        System.out.println(Integer.toBinaryString(32));
//        System.out.println(Integer.toBinaryString(23));
//        System.out.println(Integer.toBinaryString(21));
//        System.out.println(Integer.toBinaryString(11));
//        System.out.println(Integer.toBinaryString(10));
    }

}
