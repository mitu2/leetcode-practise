package runstatic.leetcode.i11_20;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author chenmoand
 */
public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int count = 0;
        for (int forOne = 0; forOne < height.length - 1; forOne++) {
            for (int forTwo = forOne + 1; forTwo < height.length; forTwo++) {
                int min = Math.min(height[forOne], height[forTwo]);
                int sp = forTwo - forOne;
//                System.out.printf("x %s - y %s - max %s - sp %s - count: %s%n", forOne, forTwo, min, sp, min * sp);
                int max = Math.max(count, sp == 0 ? min : min * sp);
                if (max > count) {
                    count = max;
                }
            }
        }
        return count;
    }

    @Test
    public void testMaxArea() {
        Assert.assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
        Assert.assertEquals(maxArea(new int[]{1, 1}), 1);
        Assert.assertEquals(maxArea(new int[]{4, 3, 2, 1, 4}), 16);
    }

    public int maxAreaV2(int[] height) {
        int count = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            count = Math.max(count, Math.min(height[start], height[end]) * (end - start));
//            int right = Math.min(height[start], height[end - 1]) * (end - start - 1);
//            System.out.printf("start: %s end: %s startVal: %s endVal: %s left: %s right: %s%n", start, end, height[start], height[end], left, right);
            if (height[start] > height[end]) {
                --end;
            } else {
                ++start;
            }
        }
        return count;
    }

    @Test
    public void testMaxAreaV2() {
//        Assert.assertEquals(maxAreaV2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
//        Assert.assertEquals(maxAreaV2(new int[]{1, 1}), 1);
//        Assert.assertEquals(maxAreaV2(new int[]{4, 3, 2, 1, 4}), 16);
        Assert.assertEquals(maxAreaV2(new int[]{1, 2, 3, 4, 5, 25, 24, 3, 4}), 24);
    }

}
