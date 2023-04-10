package geekTime.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangrucheng on 2023/4/10
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] counts = new int[26];
            for(int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            //get key
            String s = "";
            for(int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    s += (char)('a' + i);
                }
            }

            List<String> values = map.getOrDefault(s, new ArrayList<String>());
            values.add(str);
            map.put(s, values);
        }

        for(List<String> v : map.values()) {
            ans.add(v);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(arr);
        for (List<String> list : lists) {
            list.forEach(System.out::println);
            System.out.println("--------");
        }
    }
}
