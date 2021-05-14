package geekTime.sort;

import java.util.*;

public class HighestKFrequency {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = ((end - start) >> 1) + start;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, start, mid);
        } else {
            return search(nums, mid + 1, end);
        }
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public int[] searchRange(int[] nums, int target) {

    }

    public int maxKnowledge(int x, int n, int a, int b) {
        int result = 0
        while (x > 0) {
            result += x
            n--;
            x -= a;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // int[] first the value, send the frequency
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        map.forEach((num, count) -> {
            if (priorityQueue.size() == k) {
                int[] peek = priorityQueue.peek();
                if (peek[1] < count) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num, count});
                }
            } else {
                priorityQueue.offer(new int[]{num, count});
            }
        });

        int[] result = new int[k];
        int count = 0;
        for (int[] item : priorityQueue) {
            result[count++] = item[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 2};
        int[] results = new HighestKFrequency().topKFrequent(arr, 2);
        System.out.println(results);
    }
}
