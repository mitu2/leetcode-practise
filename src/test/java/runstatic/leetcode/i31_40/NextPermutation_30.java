package runstatic.leetcode.i31_40;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author chenmoand
 */
public class NextPermutation_30 {

    /**
     * 1 2 3 4
     * 1 2 4 3
     * 1 3 2 4
     * 1 3 4 2
     * 2 3 1 4
     * 2 3 4 1
     * 2 4 1 3
     * 2 4 3 1
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // 1 4 7 2 4 5
        // 1 4 7 2 5 4
        // 1 4 7 4 2 5
        // 1 4 7 4 5 2
        // 1 4 7 5 2 4
        // 1 4 7 5 4 2
        // 1 5 2 4 4 7
        for (int i = nums.length - 2; i > 0; i--) {
            int pre = nums[i - 1];
            int cur = nums[i];
            int next = nums[i + 1];
            if ((pre <= cur && cur < next) || (pre > cur && cur < next)) {
                replaceIndex(nums, i, i + 1);
                return;
            }
            if (pre < cur) {
                boolean b = false;
                if(pre == next) {
                    int index = i - 2;
                    while (index >= 0 && nums[index] == pre) {
                        -- index;
                    }
                    b = index == -1;
                }
                if (b) {
                    replaceIndex(nums, i, i - 1);
                } else {
                    int aIndex = i;
                    // 1 3 2
                    for (int j = nums.length - i - 1; j >= 0; j--) {
                        if (nums[aIndex] > nums[i + j] && nums[i + j] > nums[i - 1]) {
                            aIndex = i + j;
                        }
                    }

                    replaceIndex(nums, aIndex, i - 1);
                    sort(nums, i, nums.length);
                }
                return;
            }
        }

        flip(nums);
    }

    private void sort(int[] nums, int beginIndex, int endIndex) {
        int num = endIndex - beginIndex;
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                int a = nums[i + beginIndex];
                int b = nums[j + beginIndex];
                if (a > b) {
                    nums[i + beginIndex] = b;
                    nums[j + beginIndex] = a;
                }
            }
        }
    }

    private void replaceIndex(int[] nums, int aIndex, int bIndex) {
        int a = nums[aIndex];
        int b = nums[bIndex];
        nums[aIndex] = b;
        nums[bIndex] = a;
    }

    private void flip(int[] nums) {
        int cen = nums.length / 2;
        for (int index = 0; index < cen; index++) {
            int left = nums[index];
            int rIndex = nums.length - index - 1;
            int right = nums[rIndex];
            nums[index] = right;
            nums[rIndex] = left;
        }
    }

    @Test
    public void testFlipArray() {
        int[] nums_1 = { 3, 2, 1 };
        flip(nums_1);
        System.out.println(Arrays.toString(nums_1));
        Assert.assertEquals(nums_1, new int[]{ 1, 2, 3 });
    }

    @Test
    public void testOneNextPermutation() {
        // int[] nums_1 = { 4, 2, 0, 2, 3, 2, 0 };
        int[] nums_1 = { 4 , 2, 4, 4, 3 };

        nextPermutation(nums_1);
        System.out.println(Arrays.toString(nums_1));
        // Assert.assertEquals(nums_1, new int[]{ 2, 3, 1 });
    }

    @Test
    public void testNextPermutation() {
        int[] nums_1 = { 3, 2, 1 };
        nextPermutation(nums_1);
        System.out.println(Arrays.toString(nums_1));
        Assert.assertEquals(nums_1, new int[]{ 1, 2, 3 });
        int[] nums_2 = { 1, 2, 4, 3 };
        nextPermutation(nums_2);
        System.out.println(Arrays.toString(nums_2));
        Assert.assertEquals(nums_2, new int[]{ 1, 3, 2, 4 });
        int[] nums_3 = { 1, 3, 2 };
        nextPermutation(nums_3);
        System.out.println(Arrays.toString(nums_3));
        Assert.assertEquals(nums_3, new int[]{ 2, 1, 3 });
    }


}
