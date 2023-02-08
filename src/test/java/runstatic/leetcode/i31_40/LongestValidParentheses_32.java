package runstatic.leetcode.i31_40;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author chenmoand
 */
public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0, cur = 0;
        loop:
        for (int i = 1; i < chars.length; ) {
            char a = chars[i - 1];
            char b = chars[i];
            if (a == '(' && b == ')') {
                i += 2;
                cur += 2;
            } else if (a == '(' && b == '(') {
                int leftTotal = 2, rightTotal = 0;
                boolean con = true;
                innerLoop:
                for (int j = i + 1; j < chars.length; j++) {
                    char c = chars[j];
                    if (con) {
                        if (c == '(') {
                            leftTotal++;
                        } else {
                            con = false;
                            rightTotal++;
                        }
                    } else {
                        if (c == '(') {
                            break innerLoop;
                        } else {
                            rightTotal++;
                            if (leftTotal == rightTotal) {
                                cur += (leftTotal + rightTotal);
                                i = j + 2;
                                continue loop;
                            }
                        }
                    }
                }
                i++;
                res = Math.max(res, cur);
                cur = 0;
            } else {
                i++;
                res = Math.max(res, cur);
                cur = 0;

            }
        }
        return Math.max(res, cur);
    }

    @Test
    public void testLongestValidParentheses() {
        Assert.assertEquals(2, longestValidParentheses("()(()"));
        // Assert.assertEquals(4, longestValidParentheses("(()()"));
        // Assert.assertEquals(6, longestValidParentheses("()(())"));

    }

}
