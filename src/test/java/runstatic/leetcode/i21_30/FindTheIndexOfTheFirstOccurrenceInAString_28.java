package runstatic.leetcode.i21_30;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author chenmoand
 */
public class FindTheIndexOfTheFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        // note: String#indexOf(needle) 最快捷的实现方式
        // return haystack.indexOf(needle);
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if(haystack.equals(needle)) {
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int index = 0;
        int spec = needleChars.length;
        while (index <= haystackChars.length - spec) {
            if (Arrays.equals(haystackChars, index, index + spec, needleChars, 0, spec)) {
                return index;
            }
            System.out.println(index);
            ++index;
        }
        return -1;
    }

    @Test
    public void testIndexOf() {
        Assert.assertEquals(2, strStr("abccc", "cc"));
        Assert.assertEquals(0, strStr("a", "a"));
        Assert.assertEquals(2, strStr("abc", "c"));

    }
}
