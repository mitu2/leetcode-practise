package runstatic.leetcode.i11_20;

/**
 * @author chenmoand
 */
public class RomanToInteger_13 {

    public int romanToInt(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char chr = chars[i];
            int index = i + 1;
            switch (chr) {
                case 'M':
                    count += 1000;
                    break;
                case 'D':
                    count += 500;
                    break;
                case 'C':
                    if(isEq(chars, index, 'M')) {
                        count += 900;
                        i ++;
                    } else if(isEq(chars, index,  'D')) {
                        count += 400;
                        i ++;
                    } else {
                        count += 100;
                    }
                    break;
                case 'L':
                    count += 50;
                    break;
                case 'X':
                    if(isEq(chars, index, 'C')) {
                        count += 90;
                        i ++;
                    } else if(isEq(chars, index,  'L')) {
                        count += 40;
                        i ++;
                    } else {
                        count += 10;
                    }
                    break;
                case 'V':
                    count += 5;
                    break;
                case 'I':
                    if(isEq(chars, index, 'X')) {
                        count += 9;
                        i ++;
                    } else if(isEq(chars, index,  'V')) {
                        count += 4;
                        i ++;
                    } else {
                        count += 1;
                    }
                    break;
            }
        }
        return count;
    }

    boolean isEq(char[] chars, int index, char chr) {
        if(index >= chars.length) {
            return false;
        }
        return chars[index] == chr;
    }


}
