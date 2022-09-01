package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

import java.util.*;

/**
 * @author chenmoand
 */
public class GenerateParentheses_22 {


    // 2 ()() (())
    @TODO({"有待优化"})
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        if (n == 2) {
            return Arrays.asList("()()", "(())");
        }
        if(n == 3) {
            return Arrays.asList("()()()", "(()())", "()(())", "(())()", "((()))");
        }

        HashSet<String> result = new HashSet<>();

        for (int i = 1; i < n; i++) {
            List<String> strings = generateParenthesis(n - i);
            List<String> keys = generateParenthesis(i);
            String be = "(".repeat(i);
            String en = ")".repeat(i);
            for (String it : strings) {
                for (String key : keys) {
                    String prefix = key + it;
                    result.add(prefix);
                    String suffix = it + key;
                    result.add(suffix);
                    String center = be + it + en;
                    result.add(center);
                }
            }
        }

        return new ArrayList<>(result);
    }

    @Test
    public void testGenerateParenthesisCallback() {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
        System.out.println(strings.size());
    }


}
