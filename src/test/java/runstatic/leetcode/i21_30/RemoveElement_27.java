package runstatic.leetcode.i21_30;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author chenmoand
 */
public class RemoveElement_27 {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[index] = nums[i];
                ++ index;
            }
        }
        return index;
    }

    @Test
    public void testRemoveElement() {
        int[] nums = { 0, 0, 1, 1, 2, 3 };
        int newSize = removeElement(nums, 1);
        System.out.printf("newSize %s newArray %s", newSize, Arrays.toString(IntStream.of(nums).limit(newSize).toArray()));
    }


}
