package runstatic.leetcode.i11_20;

/**
 * @author chenmoand
 */
public class IntegerToRoman_12 {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if(num - 1000 >= 0) {
                num -= 1000;
                sb.append('M');
                continue;
            }
            if(num - 900 >= 0) {
                num -= 900;
                sb.append('C');
                sb.append('M');
                continue;
            }
            if(num - 500 >= 0) {
                num -= 500;
                sb.append('D');
                continue;
            }
            if(num - 400 >= 0) {
                num -= 400;
                sb.append('C');
                sb.append('D');
                continue;
            }
            if(num - 100 >= 0) {
                num -= 100;
                sb.append('C');
                continue;
            }
            if(num - 90 >= 0) {
                num -= 90;
                sb.append('X');
                sb.append('C');
                continue;
            }
            if(num - 50 >= 0) {
                num -= 50;
                sb.append('L');
                continue;
            }
            if(num - 40 >= 0) {
                num -= 40;
                sb.append('X');
                sb.append('L');
                continue;
            }
            if(num - 10 >= 0) {
                num -= 10;
                sb.append('X');
                continue;
            }
            if(num - 9 >= 0) {
                num -= 9;
                sb.append('I');
                sb.append('X');
                continue;
            }
            if(num - 5 >= 0) {
                num -= 5;
                sb.append('V');
                continue;
            }
            if(num - 4 >= 0) {
                num -= 4;
                sb.append('I');
                sb.append('V');
                continue;
            }
            if(num - 1 >= 0) {
                num -= 1;
                sb.append('I');
                continue;
            }
            break;
        }
        return sb.toString();
    }



}
