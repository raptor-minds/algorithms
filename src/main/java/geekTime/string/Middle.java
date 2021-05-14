package geekTime.string;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.*;

public class Middle {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> values = new ArrayList<>();
                values.add(str);
                map.put(key, values);
            }
        }
        return new ArrayList<>(map.values());
    }

    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            HashMap<Character, Boolean> map = new HashMap<>(chars.length);
            int count = 0;
            for (int j = i; j < chars.length; j++) {
                if (!map.containsKey(chars[j])) {
                    map.put(chars[j], true);
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                } else {
                    break;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int count = new Middle().lengthOfLongestSubstring(" ");
        System.out.println(count);
    }
}
