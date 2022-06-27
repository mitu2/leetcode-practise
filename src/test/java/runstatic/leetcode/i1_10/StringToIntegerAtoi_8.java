package runstatic.leetcode.i1_10;

import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

/**
 * @author chenmoand
 */
@TODO("未写出")
public class StringToIntegerAtoi_8 {


    public int myAtoi(String s) {
        Long result = null;
        char[] chars = s.toCharArray();
        boolean isNegativeNumber = false;
        boolean haveOnce = false;
        boolean firstIsNumber = false;
        root: for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            switch (aChar) {
                case ' ':
                    for (int j = i -1; j != -1; j --) {
                        if(chars[j] == ' ' || chars[j]== '+' || chars[j] == '-') {
                            continue root;
                        }
                    }
                    if(result != null) {
                        return toInt(result, isNegativeNumber);
                    }
                    break;
                case '+':
                    if(firstIsNumber || haveOnce) {
                        return toInt(getLong(result), isNegativeNumber);
                    }
                    haveOnce = true;
                    break;
                case '-':
                    if(firstIsNumber || haveOnce) {
                        return toInt(getLong(result), isNegativeNumber);
                    }
                    haveOnce = true;
                    isNegativeNumber = true;
                    break;
                case '0':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10;
                    break;
                case '1':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 1;
                    break;
                case '2':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 2;
                    break;
                case '3':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 3;
                    break;
                case '4':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 4;
                    break;
                case '5':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 5;
                    break;
                case '6':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 6;
                    break;
                case '7':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 7;
                    break;
                case '8':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 8;
                    break;
                case '9':
                    if(i == 0) {
                        firstIsNumber = true;
                    }
                    result = getLong(result) * 10 + 9;
                    break;
                default:
                    return toInt(getLong(result), isNegativeNumber);
            }
        }

        return toInt(getLong(result), isNegativeNumber);
    }

    long getLong(Long l){
        if(l == null) {
            return 0;
        }
        return l;
    }

    private int toInt(long result, boolean isNegativeNumber) {
        if(isNegativeNumber) {
            result = -result;
        }
        if (result > Integer.MIN_VALUE && result < Integer.MAX_VALUE) {
            return (int) result;
        }
        return isNegativeNumber ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }


    @Test
    public void doTest() {
        System.out.println(myAtoi("9223372036854775808"));
    }

}
