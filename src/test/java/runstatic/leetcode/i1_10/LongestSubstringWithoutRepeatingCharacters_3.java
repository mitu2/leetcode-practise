package runstatic.leetcode.i1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmoand
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int getSameStringMaxLength(String s) {
        final char[] chars = s.toCharArray();
        final int length = chars.length;
        if (length == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            f2:
            for (int j = i + 1; j < length; j++) {
                int range = i;
                while (range < j) {
                    System.out.println(range + ": " + chars[range] + " - " + j + ": " + chars[j]);
                    if (chars[range] != chars[j]) {
                        if (range == (length - 2)) {
                            count = Math.max(j - i + 1, count);
                            break f2;
                        }
                        ++range;
                    } else {
                        count = Math.max(j - i, count);
                        i = range;
                        break f2;
                    }
                }
            }
        }

        return count == 0 ? length : count;
    }

    public int lengthOfLongestSubstring(String s) {
//        List<Character> cache = new ArrayList<>();
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        int count = 0;
        root:
        for (int i = 0; i < chars.length; i++) {
//            if(count > chars.length - i) {
//                break root;
//            }
//            cache.clear();
            child:
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count = Math.max(count, j - i);
                    System.out.println("j" + j + "i" + i);
                    break child;
                }
            }
        }
        return count == 0 ? chars.length : count;
    }


    public int lengthOfLongestSubstring_2(String s) {
        List<Character> cache = new ArrayList<>();
        char[] chars = s.toCharArray();
        int count = 0;
        root:
        for (int i = 0; i < chars.length; i++) {
            if (count >= chars.length - i) {
                break root;
            }
            cache.clear();
            child:
            for (int j = i; j < chars.length; j++) {
                char chr = chars[j];
                if (!cache.contains(chr)) {
                    cache.add(chr);
                } else {
                    break child;
                }
            }
            count = Math.max(count, cache.size());
        }
        cache.clear();
        return count;
    }

    @Deprecated
    public int lengthOfLongestSubstring_1(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int count = 0;
        char[] array = s.toCharArray();
        int length = array.length;
        char[] cache = new char[length];
        int curIndex = 0;
        root:
        for (int i = 0; i < length; ) {
            int j = i;
            while (j < length) {
                System.out.println(s + " i: " + i + " j:" + j);
                if (curIndex != 0) {
                    for (int k = 0; k <= curIndex; ++k) {
                        if (cache[k] == array[j]) {
                            i = j;
                            if (count < curIndex) {
                                count = curIndex;
                            }
                            cache = new char[length - i];
                            curIndex = 0;
                            continue root;
                        }
                    }
                }
                if (j == length - 1) {
                    if (count < curIndex + 1) {
                        count = curIndex + 1;
                    }
                    break root;
                }
//                if(j == length - 1) {
//                    if(count < curIndex) {
//                        count = curIndex;
//                    }
//                    break root;
//                }
                cache[curIndex] = array[j];
                ++curIndex;
                ++j;
            }
        }
        System.out.println("count: " + count + " cur: " + curIndex);
        return count;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 instance = new LongestSubstringWithoutRepeatingCharacters_3();
        int size = instance.lengthOfLongestSubstring("asjrgapa");
        System.out.println(size);
        int size2 = instance.lengthOfLongestSubstring(" ");
        System.out.println(size2);
        int size3 = instance.lengthOfLongestSubstring("dvdf");
        System.out.println(size3);
        int size4 = instance.lengthOfLongestSubstring("abcabcbb");
        System.out.println(size4);

    }
}
