package runstatic.leetcode.i1_10;

import runstatic.leetcode.annotation.TODO;
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

    public String convert2(String s, int numRows) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int spec = Math.max(0, numRows - 2);
        int dis = spec + numRows;
        int exceed = len % (numRows + spec);
        boolean isLessRow = exceed < numRows;
        boolean isExceed = exceed != 0;
        int size = len / (numRows + spec);

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            boolean isFirst = row == 0;
            boolean isEnd = row == numRows - 1;
            int colFrom = size;
            if (!(isEnd || isFirst)) {
                colFrom += size;
            }
            boolean isSpecialRow = row < spec;
            if (isExceed) {
                if (isLessRow) {
                    if (isSpecialRow) {
                        colFrom += 1;
                    }
                } else {
                    if (numRows - row > spec) {
                        colFrom += 1;
                    }
                }
            } else {
                colFrom -= 1;
            }
//            System.out.println(dis);

            boolean b = isSpecialRow;
            for (int col = 0, preIndex = row; col < colFrom; col++) {
                if (col == 0) {
                    sb.append(chars[row]);
                    continue;
                }

                if(isFirst || isEnd) {
                    sb.append(chars[col * dis]);
                    continue;
                }
                if(row == 1 && numRows == 3) {
                    sb.append(chars[preIndex += 2]);
                    continue;
                }

                if(b) {
                    sb.append(chars[preIndex += numRows]);
                } else {
                    sb.append(chars[preIndex += spec]);
                }
                b = !b;


//                int index = row + (i * col) + (col == 0 ? 0 : (col == colFrom - 1) ? 2 : 1);
//                System.out.printf("row %s col %s [i %s] index %s%n", row, col, i, index);
//                sb.append(chars[index]);
            }
        }


        return sb.toString();
    }

    @TODO("跳过了")
    public static void main(String[] args) {
        ZigZagConversion_6 instance = new ZigZagConversion_6();
        /**
         * A 00   0
         * E 01 3 4
         * PAHNAPLSIIGYIR
         *
         */
        System.out.println(instance.convert2("PAYPALISHIRING", 3));
    }

}
