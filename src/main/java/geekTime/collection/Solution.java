package geekTime.collection;

import java.util.*;

/**
 * @author zhangrucheng on 2023/4/1
 */
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }

        for (int[] ints : items2) {
            Integer value = map.get(ints[0]);
            if (value != null) {
                map.put(ints[0], value + ints[1]);
            }
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            ret.add(temp);
        }

        ret.sort(Comparator.comparingInt(l -> l.get(0)));
        return ret;
    }
}
