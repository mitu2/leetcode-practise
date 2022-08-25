package runstatic.leetcode.i11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenmoand
 */
public class LetterCombinationsOfAPhoneNumber_17 {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        char[] chars = digits.toCharArray();
        List<String> result = null;
        for (char aChar : chars) {
            switch (aChar) {
                case '2':
                    result = takeArray(result, new String[]{"a", "b", "c"});
                    break;
                case '3':
                    result = takeArray(result, new String[]{"d", "e", "f"});
                    break;
                case '4':
                    result = takeArray(result, new String[]{"g", "h", "i"});
                    break;
                case '5':
                    result = takeArray(result, new String[]{"j", "k", "l"});
                    break;
                case '6':
                    result = takeArray(result, new String[]{"m", "n", "o"});
                    break;
                case '7':
                    result = takeArray(result, new String[]{"p", "q", "r", "s"});
                    break;
                case '8':
                    result = takeArray(result, new String[]{"t", "u", "v"});
                    break;
                case '9':
                    result = takeArray(result, new String[]{"w", "x", "y", "z"});
                    break;
            }
        }
        return result;
    }

    public List<String> takeArray(List<String> list, String[] strings) {
        if (list == null) {
            return Arrays.asList(strings);
        }
        List<String> newList = new ArrayList<>(strings.length * list.size());

        for (String s : list) {
            for (String string : strings) {
                newList.add(s + string);
            }
        }
        return newList;
    }


}
