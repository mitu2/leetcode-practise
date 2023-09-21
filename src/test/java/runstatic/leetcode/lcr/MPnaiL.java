package runstatic.leetcode.lcr;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @website https://leetcode.cn/problems/MPnaiL/submissions/
 * @author chenmoand
 * @date 2023/9/21 19:17
 */
public class MPnaiL {

    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        char[] s1Chars = s1.toCharArray();

        // 正确解法的是Map优化成 int[26] 特此记下
        Map<Character, Integer> s1CountMaps = getCountMaps(s1Chars);
        Map<Character, Integer> s2CountMaps = null;
        int length = s2.length();
        for (int i = 0; i <= length - len; i++) {
            if (s2CountMaps == null) {
                char[] dst = new char[len];
                s2.getChars(i, i + len, dst, 0);
                s2CountMaps = getCountMaps(dst);
            } else {
                s2CountMaps.computeIfPresent(s2.charAt(i - 1), (key, count) -> count == 1 ? null : count - 1);
                char newKey = s2.charAt(i + len - 1);
                s2CountMaps.put(newKey, s2CountMaps.getOrDefault(newKey, 0) + 1);
            }
            if (s1CountMaps.equals(s2CountMaps)) {
                return true;
            }
        }
        return false;
    }

    public Map<Character, Integer> getCountMaps(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public String sortString(String sortString) {
        char[] charArray = sortString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] > charArray[j]) {
                    char c = charArray[j];
                    charArray[j] = charArray[i];
                    charArray[i] = c;
                }
            }
        }

        return new String(charArray);
    }

    int getCharsInt(char[] chars) {
        int result = 0;
        for (char c : chars) {
            result += (int) c;
        }
        return result;
    }

    @Test
    public void testCase() {
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assert.assertFalse(checkInclusion("abc", "ccccbbbbaaaa"));

    }


}
