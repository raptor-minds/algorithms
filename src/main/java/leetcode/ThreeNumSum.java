package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangrucheng on 2023/4/11
 */
public class ThreeNumSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i-1 >= 0 && nums[i] == nums[i-1]) {
                continue;
            }
            process(nums, i + 1, nums.length - 1, -nums[i], ans);
        }
        return ans;
    }

    private static void process(int[] nums, int L, int R, int target, List<List<Integer>> ans) {
        while (L < R) {
            if (nums[L + 1] == nums[L]) {
                L++;
                continue;
            }

            while (nums[L] + nums[R] > target) {
                R--;
                if (R <= L) {
                    return;
                }
            }

            if (nums[L] + nums[R] == target) {
                List<Integer> item = new ArrayList<>();
                item.add(-target);
                item.add(nums[L]);
                item.add(nums[R]);
                ans.add(item);
            }

            L++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeNumSum().threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println("------");
        }
    }

}
