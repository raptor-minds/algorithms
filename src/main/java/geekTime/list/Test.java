package geekTime.list;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        if (chars.length < 2) {
            return s;
        }

        boolean[][] dp = new boolean[chars.length][chars.length];

        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;

        // 枚举子串长度
        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                int j = L + i - 1;
                if (j > s.length() - 1) {
                    break;
                }

                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Test().longestPalindrome("bb"));
    }
}
