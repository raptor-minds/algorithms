package geekTime.string;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        List<List<String>> result = new ArrayList<>();
        List<String> init = new ArrayList<>(s.length());
        boolean[][] isPalindrome = new boolean[][]{};
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int L = 2; L <= s.length(); L++) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int j = i + L - 1;
                if (j >= s.length()) {
                    continue;
                }
                if (chars[i] == chars[j]) {
                    if (isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
    }
}
