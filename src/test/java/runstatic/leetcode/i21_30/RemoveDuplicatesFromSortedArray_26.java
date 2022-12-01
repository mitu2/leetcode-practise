package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author chenmoand
 */
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int index = 1;
        int preVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preVal != nums[i]) {
                preVal = (nums[index] = nums[i]);
                ++index;
            }
        }
        return index;
    }


    @Test
    public void testRemoveDuplicates() {
        int[] nums = { 0, 0, 1, 1, 2, 3 };
        int newSize = removeDuplicates(nums);
        System.out.printf("newSize %s newArray %s", newSize, Arrays.toString(IntStream.of(nums).limit(newSize).toArray()));
    }

}
