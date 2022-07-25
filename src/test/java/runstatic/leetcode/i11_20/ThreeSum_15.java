package runstatic.leetcode.i11_20;

import org.testng.Assert;
import org.testng.annotations.Test;
import runstatic.leetcode.annotation.TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenmoand
 */
public class ThreeSum_15 {

    @TODO("超时了。。。")
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sVal = nums[start];
            int eVal = nums[end];
//            System.out.printf("c %s_%s_%s%n",start, end, mid);
            while (mid < end && mid > start) {
                int mVal = nums[mid];
                System.out.printf("i %s_%s_%s%n",start, end, mid);
                int i = sVal + eVal + mVal;
                if (i > 0) {
                    mid -= 1;
                } else if (i < 0) {
                    mid += 1;
                } else {
                    result.add(Arrays.asList(sVal, eVal, mVal));
                    break;
                }
            }
            start += 1;
        }
        System.out.println(result);
        return result;
    }


    @Test
    public void testThreeSum() {
        Assert.assertEqualsNoOrder(threeSum(new int[]{-1, 0, 1, 2, -1, -4}), Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)));
    }


}
