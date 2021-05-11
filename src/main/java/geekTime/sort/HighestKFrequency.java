package geekTime.sort;

import java.util.*;

public class HighestKFrequency {

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
