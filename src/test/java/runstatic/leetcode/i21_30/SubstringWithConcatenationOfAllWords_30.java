package runstatic.leetcode.i21_30;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author chenmoand
 */
public class SubstringWithConcatenationOfAllWords_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int strLen = s.length();
        int wordLen = words[0].length();
        int maxI = strLen - wordLen * words.length;
        for (int i = 0; i <= maxI; i++) {
            Deque<String> vector = new LinkedList<>(Arrays.asList(words));
            for (int j = i; j + wordLen <= strLen && vector.size() > 0; j += wordLen) {
                if (!vector.remove(s.substring(j, j + wordLen))) {
                    break;
                }
            }
            if (vector.size() == 0) {
                result.add(i);
            }
        }
        return result;
    }

    // 1 2 3
    // 2 1 3
    // 3 1 2
    // 1 3 2
    // 2 3 1
    // 3 2 1
    public List<String> getLinkWords(String[] words) {
        List<String> keys = new ArrayList<>();

        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; ++j) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[i]);
                int o = 0;
                for (int k = 0; k < length - 1; k++) {
                    int basPos = i + j + k + o;
                    int pos = basPos >= length ? basPos % length : basPos;
                    if (pos == i) {
                        o = 1;
                        pos += o;
                        if (pos >= length) {
                            pos %= length;
                        }
                    }
                    System.out.printf("[info] i: %s j: %s k: %s basPos: %s pos: %s%n", i, j, k, basPos, pos);
                    sb.append(words[pos]);
                }
                System.out.println();
                keys.add(sb.toString());
            }
        }
        return keys;
    }

    @Test
    public void testFindSubstring() {
        // List<String> linkWords = getLinkWords(new String[]{ "fooo", "barr", "wing", "ding", "wing" });
        // System.out.println(linkWords.size());
        Assert.assertEquals(List.of(13), findSubstring("wordgoodgoodgoodbestword", new String[]{ "word","good","best","good" }));
        Assert.assertEquals(Arrays.asList(0, 9), findSubstring("barfoothefoobarman", new String[]{ "foo", "bar" }));
        Assert.assertEquals(List.of(13), findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{ "fooo", "barr", "wing", "ding", "wing" }));
    }



    @Test
    public void testLinkedList() {
        Deque<String> vector = new LinkedList<>(Arrays.asList("1", "1", "2", "3"));
        // vector.remove("1");
        // vector.remove("1");
        System.out.println(vector);
    }
}
