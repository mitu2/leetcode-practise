package runstatic.leetcode.i31_40;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author chenmoand
 * @date 2023/11/30 21:23
 */
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int cen = 0;
        while (start <= end) {
            cen = start + (end - start) / 2;
            int num = nums[cen];
            if (num == target) {
                return cen;
            }
            if (num > target) {
                end = cen - 1;
            } else {
                start = cen + 1;
            }
        }
        if (nums[cen] > target) {
            return cen;
        }
        return cen + 1;
    }

    @Test
    public void testCase() {
        // 1 3 6 7
        Assert.assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 2), 1);

        Assert.assertEquals(searchInsert(new int[]{1, 3}, 2), 1);
        Assert.assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 7), 4);

    }

}
