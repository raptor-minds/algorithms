package geekTime.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangrucheng on 2023/4/10
 * <a href="https://leetcode.cn/problems/repeated-dna-sequences/">...</a>
 */
public class DNA {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            Integer count = map.get(sub);
            if (count == null || count == 0) {
                map.put(sub, 1);
            } else {
                map.put(sub, ++count);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                ans.add(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "AAAAAAAAAAA";
        List<String> repeatedDnaSequences = new DNA().findRepeatedDnaSequences(test);
        repeatedDnaSequences.forEach(System.out::println);
        System.out.println((char) ('a' + 1));
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
}
