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

        // 为什么取 nums.length - 2? 为什么 1 > 0 而不是 1>= 0？
        // 因为在下文代码会取一个i + 1 和 i - 1这样会减少数组边界的检查
        // 这里采用了从末尾往首遍历方式
        for (int i = nums.length - 2; i > 0; i--) {
            // pre 上一个 cur 当前 next 下一个
            int pre = nums[i - 1];
            int cur = nums[i];
            int next = nums[i + 1];
            // pre <= cur && cur < next 代表下面情况
            // 例子 1 2 3 4 当 pre = 2, cur = 3, next = 4，结果 1 2 4 3
            // pre > cur && cur < next 代表下面情况
            // 例子 1 3 2 4 当 pre = 3, cur = 2, next = 4，结果 1 3 4 2
            // 这两种情况只需要把 cur 和 next 的位置替换一下
            if ((pre <= cur && cur < next) || (pre > cur && cur < next)) {
                replaceIndex(nums, i, i + 1);
                return;
            }
            if (pre < cur) {
                boolean b = false;

                if (pre == next) {
                    // 这里判断是方式  【 1，   1，    4，    1 】这种极端数组的情况下
                    //                      pre    cur    next
                    // 从pre的前面开始寻找
                    int index = i - 2;
                    while (index >= 0 && nums[index] == pre) {
                        --index;
                    }
                    b = index == -1;
                }
                // 如果是极端数组只需要把cur跟pre替换位置即可
                if (b) {
                    replaceIndex(nums, i, i - 1);
                }
                // 这里需要处理 【 1，  2，   4，    3 】
                //                   pre   cur   next
                else {

                    // 寻找比pre 大且从 i - num.length - 1 最小的一个值
                    int aIndex = i;
                    for (int j = nums.length - i - 1; j >= 0; j--) {
                        if (nums[aIndex] > nums[i + j] && nums[i + j] > nums[i - 1]) {
                            aIndex = i + j;
                        }
                    }
                    // 替换上文找到将 pre 跟 aIndex 进行替换
                    replaceIndex(nums, aIndex, i - 1);
                    // 排序
                    sort(nums, i, nums.length);
                }
                return;
            }
        }
        // 这是一个兜底操作， 如果 【5，4，3，2，1】
        // 这种根本就找不到下一个数组的情况下那吗将执行翻转方法
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

    /**
     * 翻转数组
     */
    private void flip(int[] nums) {
        // 取数组长度的一半是因为换的是 左 右 两边的替换
        // 无需担心是否是偶数还是奇数长度的数组
        int cen = nums.length / 2;
        for (int index = 0; index < cen; index++) {
            // 取左边的值
            int left = nums[index];
            // 取右边的下表
            int rIndex = nums.length - index - 1;
            int right = nums[rIndex];
            // 交换两边的
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
        int[] nums_1 = { 4, 2, 4, 4, 3 };

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
