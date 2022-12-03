package runstatic.leetcode.i21_30;

import org.testng.Assert;
import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

/**
 * @author chenmoand
 */
public class DivideTwoIntegers_29 {

    @TODO("效率不咋样")
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return (~dividend) + (dividend & 1);
        }
        boolean b = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0);
        int num = 0;
        if (b) {
            if (dividend < 0) {
                while (dividend <= divisor) {
                    dividend -= divisor;
                    num++;
                }
            } else {
                while (dividend >= divisor) {
                    dividend -= divisor;
                    num++;
                }
            }
        } else {
            if (dividend < 0) {
                while (dividend + divisor <= 0) {
                    dividend += divisor;
                    num++;
                }
            } else {
                int letDivisor = -divisor;
                while (dividend - letDivisor >= 0) {
                    dividend -= letDivisor;
                    num++;
                }
            }

            num = -num;
        }
        return num;
    }

    public int divide_v2(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return (~dividend) + (dividend & 1);
        }
        int absDividend = abs(dividend);
        int absDivisor = abs(divisor);
        System.out.printf("absDividend %s  absDivisor %s %n", absDividend, absDivisor);
        if (absDividend < absDivisor) {
            return 0;
        }
        if (absDividend - absDivisor < absDivisor) {
            return 1;
        }

        if ((divisor & 1) == 0) {
            return divisor > 0 ?
                    dividend >> (divisor >> 1) :
                    fu((dividend >> (absDivisor >> 1)));
        }
        if (divisor > 0) {
            return dividend >> divisor << 1;
        }
        int fu = fu(fc(dividend >> absDivisor << 1));
        return fu;
    }

    public int fc(int i) {
        System.out.println( "fc " +  i);
        if (i < 0) {
            return i + 1;
        }
        return i;
    }

    public int abs(int i) {
        if (i > 0) {
            return i;
        }
        return fu(i);
    }

    public int fu(int i) {
        int ri = ~i;
        if (i < 0) {
            return ri == Integer.MAX_VALUE ? ri : ri + 1;
        } else {
            return ri == Integer.MIN_VALUE ? ri : ri + 1;
        }
    }

    @Test
    public void testDivide() {
        System.out.println(7 >> 3);
        System.out.println(fu(3));
        Assert.assertEquals(-1073741824, divide_v2(-2147483648, 2));
        // Assert.assertEquals(715827882, divide_v2(-2147483648, -3));

        Assert.assertEquals(-2, divide_v2(7, -3));
        Assert.assertEquals(3, divide_v2(7, 2));
        Assert.assertEquals(-3, divide_v2(7, -2));
        Assert.assertEquals(-2147483648, divide_v2(-2147483648, 1));
        Assert.assertEquals(2147483647, divide_v2(-2147483648, -1));

        Assert.assertEquals(3, divide_v2(10, 3));
        Assert.assertEquals(3, divide_v2(11, 3));

        Assert.assertEquals(5, divide_v2(15, 3));

    }

    @Test
    public void testOther() {
        System.out.println(-7 >> 1);
        System.out.println(abs(-7 >> 1));
        System.out.println(7 >> 2 << 1);
        System.out.println(~-2147483648);
        // System.out.println(-2147483648 >> (1 >> 1));
        // System.out.println((-2 >> 1));
        // System.out.println(7 >> (2 >> 1));
        // System.out.println(20 / 3);
        // System.out.println(((10 << 1 >> 3) + 1));
        // System.out.println(2 & 1);
        System.out.println(10 >> 3);
        System.out.println(15 << 1);
        System.out.println(30 >> 3);
        System.out.println(15 << 1 >> 3);
        System.out.println(-2 & 1);
        System.out.println(~1);
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }

}
