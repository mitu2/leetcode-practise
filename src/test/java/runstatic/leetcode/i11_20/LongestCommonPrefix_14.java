package runstatic.leetcode.i11_20;

/**
 * @author chenmoand
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Character chr = null;
        root:
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                int len = sb.length();
                if (len >= str.length()) {
                    break root;
                }
                if (i == 0) {
                    chr = str.charAt(len);
                } else if (chr != str.charAt(len)) {
                    break root;
                }
            }
            sb.append(chr);
        }
        return sb.toString();
    }

}
