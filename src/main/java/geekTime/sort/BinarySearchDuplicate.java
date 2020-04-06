package geekTime.sort;

public class BinarySearchDuplicate {

    public int searchFist(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] == target) {
                if (middle == 0 || nums[middle - 1] != target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public int searchLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] == target) {
                if (middle == nums.length - 1 || nums[middle + 1] != target) return middle;
                else low = middle + 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10};
        BinarySearchDuplicate binarySearchDuplicate = new BinarySearchDuplicate();
        System.out.println(binarySearchDuplicate.searchFist(nums, 7));
        System.out.println(binarySearchDuplicate.searchLast(nums, 8));
    }
}
