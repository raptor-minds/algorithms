package geekTime.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            BinarySearch binarySearch = new BinarySearch();
            if (binarySearch.search(whitelist, key) == -1) {
                StdOut.println(key);
            }
        }
    }
}
