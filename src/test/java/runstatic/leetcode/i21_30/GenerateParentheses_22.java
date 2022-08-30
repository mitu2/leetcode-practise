package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

import java.util.*;

/**
 * @author chenmoand
 */
public class GenerateParentheses_22 {

    static final Map<Integer, List<String>> cacheMap = new HashMap<>();

    // 2 ()() (())
    @TODO("有待优化")
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        List<String> cacheList = cacheMap.get(n);
        if(cacheList != null) {
            return cacheList;
        }
        List<String> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            List<String> strings = generateParenthesis(n - i);
            List<String> keys = generateParenthesis(i);
            String be = "(".repeat(i);
            String en = ")".repeat(i);
            for (String it : strings) {
                for (String key : keys) {
                    String prefix = key + it;
                    if (!result.contains(prefix)) {
                        result.add(prefix);
                    }
                    String suffix = it + key;
                    if (!result.contains(suffix)) {
                        result.add(suffix);
                    }
                    String center = be + it + en;
                    if (!result.contains(center)) {
                        result.add(center);
                    }
                }
            }
        }

        cacheMap.put(n, result);
        return result;
    }

    @Test
    public void testgenerateParenthesisCallback() {
        List<String> strings = generateParenthesis(5);
        System.out.println(strings);
        System.out.println(strings.size());
    }


}
