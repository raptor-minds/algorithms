package strings;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int count =0;

        for (int i = 0; i < nums.length - count; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        continue;
                    }
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbs = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(numbs);
        System.out.println(Arrays.toString(numbs));
    }
}
