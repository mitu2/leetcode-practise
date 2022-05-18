package runstatic.leetcode.i1_10;

import runstatic.leetcode.annotation.Wrong;

/**
 * @author chenmoand
 */
public class LongestPalindromicSubstring_4 {

    @Wrong
    public String longestPalindrome(String s) {
        int start = 0, end = 0, len = 0;

        char[] chars = s.toCharArray();
        root:
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    int sameLen = j - i;
                    if (sameLen > len || j <= end) {
                        start = i;
                        end = j;
                        len = sameLen;
                    }
                    if (len == chars.length - 1) {
                        break root;
                    }
                    if (j + 1 < chars.length && chars[j + 1] != chars[i]) {
                        continue root;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public String longestPalindrome_2(String s) {
        int start = 0, end = 0, len = 0;

        char[] chars = s.toCharArray();
        int clen = chars.length;

        for (int i = 0; i < clen; i++) {
            boolean isNotEnd = i + 1 < clen;
            if (!isNotEnd) {
                continue;
            }
            if (i != 0 && chars[i - 1] == chars[i + 1]) {
                int st = i - 2, ed = i + 2, nl = 3;
                boolean isSucStart = true;
                if (chars[i] != chars[i - 1]) {
                    do {
                        if (st >= 0 && ed < clen && chars[st] == chars[ed]) {
                            st--;
                            ed++;
                            nl += 2;
                        } else {
                            isSucStart = false;
                        }
                    } while (isSucStart);
                    if (nl > len) {
                        start = st + 1;
                        end = ed - 1;
                        len = nl;
                    }
                    continue;
                }
//                st = i - 2;
//                ed = i + 2;
//                nl = 3;
                boolean isSucEnd = true;
                do {
                    boolean isStart = st >= 0;
                    if (isStart && chars[st] == chars[i]) {
                        st--;
                        nl++;
                    } else {
                        isSucStart = false;
                    }
                    boolean isEnd = ed < clen;
                    if (isEnd && chars[ed] == chars[i]) {
                        ed++;
                        nl++;
                    } else {
                        isSucEnd = false;
                    }

//                    System.out.println("ed" + ed + " clen" + clen + " isEnd " + isEnd);

                    if (!(isSucStart && isSucEnd) && st >= 0 && ed < clen && chars[st] == chars[ed]) {
                        st--;
                        ed++;
                        nl += 2;
                        isSucStart = true;
                        isSucEnd = true;
                    }


                } while (isSucStart && isSucEnd);

//                System.out.println("nl " + nl);
                if (nl > len) {
                    start = st + 1;
                    end = ed - 1;
                    len = nl;
                }

                continue;
            }
            if (chars[i] == chars[i + 1]) {
                if (i == 0) {
                    start = 0;
                    end = 1;
                    len = 2;
                    continue;
                }
                int st = i - 1, ed = i + 2, nl = 2;
                while (st >= 0 && ed < clen) {
                    if (chars[st] != chars[ed]) {
                        break;
                    }
                    st--;
                    ed++;
                    nl += 2;
                }
//                System.out.println("st:" + st + " isERR:" + isEr);
                //fix bug
                if (nl > len) {
                    start = st + 1;
                    end = ed - 1;
                    len = nl;
                }
            }
        }

        return s.substring(start, end + 1);
    }


    //输入：
    //"abcba"
    //输出：
    //"bcb"
    //预期结果：
    //"abcba"

    /**
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 94.29%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 52.05%
     * 的用户
     * 通过测试用例：
     * 180 / 180
     */
    public static void main(String[] args) {
        LongestPalindromicSubstring_4 instance = new LongestPalindromicSubstring_4();
        String result = instance.longestPalindrome_2("aaabaaaa");
        System.out.println(result);
    }
}
