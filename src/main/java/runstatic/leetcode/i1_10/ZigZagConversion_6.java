package runstatic.leetcode.i1_10;

import runstatic.leetcode.annotation.Wrong;

/**
 * @author chenmoand
 */
public class ZigZagConversion_6 {

    @Wrong("错误的理解")
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int vNum = (2 * numRows - 2);
        int maxRow = chars.length / vNum;
        int inc = chars.length % vNum;
        boolean isEven = numRows % 2 == 0;
        System.out.println("vNum = " + vNum + " inc = " + inc + " maxRow = " + maxRow);
        // (numRows - 2) + (numRows - 1)
        int sm = 2 * numRows - 3;
        for (int i = 0; i < numRows; ++i) {
            // int appendOffset = i + numRows;
            boolean isNextSpecial = false;
            boolean isMid = i != 0 && i != (numRows - 1);
            int leftSpecialOffset = sm - getOffset(i);
            int rightSpecialOffset = sm - leftSpecialOffset - 1;
            int curColMaxRow = maxRow;
            if (i == numRows - 1 || i == 0) {
                curColMaxRow -= (isEven ? numRows - i + 1 : i) - inc >= 0 ? 1 : 0;
            } else {
                curColMaxRow = maxRow + (maxRow - 1) + ((isEven ? numRows - i + 1 : i) - inc >= 0 ? 0 : 1);
            }
            for (int curRow = 0; curRow <= curColMaxRow; ++curRow) {
                // System.out.println("i = " + i + "  curRow = " + curRow);

                if (curRow == 0) {
                    sb.append(chars[i]);
                } else if (isMid) {
                    if (isNextSpecial) {
                        sb.append(chars[(numRows - i - 1) + curRow * (numRows - 2) + curRow]);
                    } else {
                        sb.append(chars[i + curRow * (numRows - 2) + curRow]);
                    }
                } else {
                    // System.out.println("i = " + i + "  curRow = " + curRow);
                    sb.append(chars[i + curRow * (numRows + 1)]);
                }


                // sb.append('-');
                if (curRow == curColMaxRow) {
                    sb.append('\n');
                    continue;
                }
                // index += appendOffset;
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
        // i + i
        return i << 1;
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
        /**
         * A 00   0
         * E 01 3 4
         */
        System.out.println(instance.convert("PAYPALISHIRING", 3));
    }

}
