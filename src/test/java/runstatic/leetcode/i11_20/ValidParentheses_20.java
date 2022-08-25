package runstatic.leetcode.i11_20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @author chenmoand
 */
public class ValidParentheses_20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> cacheChars = new Stack<>();
        for (char chr : chars) {
            boolean isLeft = chr == '{' || chr == '(' || chr == '[';
            if (cacheChars.size() == 0) {
                if (!isLeft) {
                    return false;
                }
                cacheChars.push(chr);
                continue;
            }
            if (isLeft) {
                cacheChars.push(chr);
                continue;
            }

            int range = chr - cacheChars.pop();

            if (range < 0 || range > 2) {
                return false;
            }
        }


        return cacheChars.size() == 0;
    }

    @Test
    public void testIsValid() {
        Assert.assertTrue(isValid("()"));
        Assert.assertFalse(isValid("{]"));
    }

    public static void main(String[] args) {
        System.out.println((int) '{'); // 123
        System.out.println((char) 124);
        System.out.println((int) '}'); // 125
        System.out.println((int) '('); // 40
        System.out.println((int) ')'); // 41
        System.out.println((int) '['); // 91
        System.out.println((char) 92);
        System.out.println((int) ']'); // 93
    }


}
