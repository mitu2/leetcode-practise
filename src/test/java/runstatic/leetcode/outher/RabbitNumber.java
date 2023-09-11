package runstatic.leetcode.outher;

import org.testng.annotations.Test;

/**
 * @author chenmoand
 * @date 2023/9/11 20:11
 */
public class RabbitNumber {

    /**
     * 计算兔子数量
     * 有一对兔子，从出生后第 3 个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，求第n个月的兔子总对数为多少？
     */
    public int getMaxRabbitNumber(int n) {
        if (n < 3) {
            return 1;
        }
        int[] smail = new int[]{0, 0, 1};
        int big = 0;

        for (int i = 0; i < n; i++) {
            smail[0] = smail[1];
            smail[1] = smail[2];
            smail[2] = big;
            big += smail[0];
        }

        return smail[0] + smail[1] + smail[2] + big;
    }

    @Test
    public void testCase() {
        int maxNumber = getMaxRabbitNumber(6);
        System.out.println(maxNumber);
    }

}
