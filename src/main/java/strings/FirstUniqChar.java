package strings;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char single = '0';
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {

            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == single) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }
}
