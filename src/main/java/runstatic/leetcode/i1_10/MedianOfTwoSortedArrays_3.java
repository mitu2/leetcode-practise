package runstatic.leetcode.i1_10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenmoand
 */
public class MedianOfTwoSortedArrays_3 {


    /**
     * ~ 1 2 3 4 | 3 4 | 1 2 3 3 4 4
     * ~ 1 3 5 | 1 2 4 5 7 | 1 1 2 3 4 5 5 7
     * ~ 1 2 4  | 1 2 3 4 5 | 1 1 2 2 3 4 4 5 5
     * ~ 1 2 3 4 | 1 2 3   | 1 1 2 2 3 3 4
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        boolean isEven = (len1 + len2) % 2 == 0;
        int index = (int) Math.ceil((len1 + len2) / 2F);
        if (len1 != 0 && len2 != 0 && nums1[len1 - 1] <= nums2[0]) {
            if (isEven) {
                // @formatter:off
                return (
                        (index > len1 ? nums2[index - len1 - 1] : nums1[index - 1]) +
                        (index + 1 > len1 ? nums2[index - len1] : nums1[index])
                ) / 2D;
                // @formatter:on
            } else {
                return (index > len1 ? nums2[index - len1 - 1] : nums1[index - 1]);
            }
        }

//        int index_1 = (int) Math.ceil(len1 / 2F) - 1, index_2 = (int) Math.ceil(len2 / 2F) - 1;

//        if(isEven) {
//            return (nums1[index_1] + nums2[index_2]) / 2D;
//        }
        List<Integer> list = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed())
                .sorted()
                .collect(Collectors.toList());

        return isEven ?  (list.get(index - 1) + list.get(index)) / 2D : list.get(index - 1);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_3 instance = new MedianOfTwoSortedArrays_3();
        double result1 = instance.findMedianSortedArrays(new int[]{}, new int[]{3, 4});
        System.out.println(result1);
        double result2 = instance.findMedianSortedArrays(new int[]{1 ,2}, new int[]{1, 4});
        System.out.println(result2);
    }


}
