package runstatic.leetcode.i1_10;

/**
 * @author chenmoand
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++ i) {
            for(int j = 1; j < nums.length; ++ j) {
                if(i == j) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    return new int[] { i, j};
                }
            }
        }
        return new int[0];
    }

}
