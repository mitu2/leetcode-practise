package runstatic.leetcode.i1_10;

import runstatic.leetcode.annotation.TODO;

/**
 * @author chenmoand
 */
public class ZigZagConversion_6 {

    @TODO("未完成")
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int cenChr = numRows - 2;
        StringBuilder sb = new StringBuilder();
//        int indexMaxLen = chars.length - 1;

        int sm = numRows + 1;
        for (int i = 0; i < numRows; ++i) {
            int appendOffset = i + numRows;
            boolean isNextSpecial = false;
            boolean isMid = i != 0 && i != (numRows - 1);
            int leftSpecialOffset = sm -  getOffset(i);
            int rightSpecialOffset = sm - leftSpecialOffset - 1;
            // TODO 优化输出
            for (int index = i; index < chars.length; index += appendOffset) {
                sb.append(chars[index]);
                if(index + appendOffset >= chars.length && i != numRows - 1) {
                    sb.append('\n');
                    continue;
                }
                if (!isMid) {
                    sb.append(getBlank(sm));
                    continue;
                }
                if (isNextSpecial) {
                    sb.append(getBlank(rightSpecialOffset));
                    isNextSpecial = false;
                } else {
                    sb.append(getBlank(leftSpecialOffset));
                    isNextSpecial = true;
                }

            }
        }

        return sb.toString();
    }
    public int getOffset(int i) {
        if(i == 1) {
            return 2;
        }
        return i + 2;
    }

    public StringBuilder getBlank(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; ++i) {
            sb.append(' ');
        }
        return sb;
    }

    public static void main(String[] args) {
        ZigZagConversion_6 instance = new ZigZagConversion_6();
        System.out.println(instance.convert("ABCDEFGADAHGGFFYFYUFYFFGJHFGJHFJHFJGHUKGUGIUGG", 4));
    }

}
