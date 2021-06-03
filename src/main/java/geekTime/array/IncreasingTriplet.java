package geekTime.array;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int head = 0, middle = 1, tail = 2;
        while (tail < nums.length) {
            if (nums[head] < nums[middle]) {
                if (nums[middle] < nums[tail]) {
                    return true;
                } else {
                    head += 2;
                    middle += 2;
                    tail += 2;
                }
            } else {
                head++;
                middle++;
                tail++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 0, 4, 6};
        new IncreasingTriplet().increasingTriplet(nums);
    }
}
