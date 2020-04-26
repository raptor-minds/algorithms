package geekTime.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums.length <= 2) return results;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int head = i + 1, tail = nums.length - 1;
            while (head < tail) {
                if (nums[head] + nums[tail] + nums[i] == 0) {
                    List<Integer> result = new LinkedList<Integer>();
                    result.add(nums[head]);
                    result.add(nums[tail]);
                    result.add(nums[i]);
                    results.add(result);
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    while (tail > head && nums[tail] == nums[tail - 1]) tail--;
                    head++;
                    tail--;
                } else if (head + tail < nums[i]) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        //System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));

        String name = "baas.dianrong.com";
        String[] strings = name.split("\\.");
        int len = strings.length;
        System.out.println(Arrays.toString(strings));
        System.out.println(strings[len - 2] + "." + strings[len -1]);
    }
}
