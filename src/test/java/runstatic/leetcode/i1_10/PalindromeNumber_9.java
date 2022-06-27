package runstatic.leetcode.i1_10;

import org.testng.annotations.Test;

/**
 * @author chenmoand
 */
public class PalindromeNumber_9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }


    public boolean isPalindrome2(int x) {
        int innerX = x;
        if (x < 0) {
            return false;
        }
        int count = 0;
        int incr = 1;
        while (innerX != 0) {
            int i = innerX % 10;
            count = count * incr + i;
            if(incr == 1) {
                incr *= 10;
            }
            innerX /= 10;
        }
        return count == x;
    }

    @Test
    public void testPalindrome2() {
        System.out.println(isPalindrome2(1001));
    }
}
