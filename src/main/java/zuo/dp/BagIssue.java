package zuo.dp;

/**
 * @author zhangrucheng on 2023/4/14
 */
public class BagIssue {

    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process1(w, v, 0, bag);
    }

    private static int dpWay(int[] w, int[] v, int bag) {
        int[][] dp = new int[w.length + 1][bag + 1];
        for (int i = 0; i <= w.length; i++) {
            dp[i][0] = -1;
        }

        for (int i = 0; i <= bag; i++) {
            dp[w.length][i] = 0;
        }

        for (int i = w.length - 1; i >= 0; i--) {
            for (int rest = 0; rest <= bag; rest++) {
                if (rest - w[i] < 0) {
                    dp[i][rest] = dp[i + 1][rest];
                } else {
                    dp[i][rest] = Math.max(v[i] + dp[i + 1][rest - w[i]], dp[i + 1][rest]);
                }
            }
        }
        return dp[0][bag];
    }

    private static int process1(int[] w, int[] v, int cur, int rest) {
        if (rest <= 0) {
            return -1;
        }
        if (cur == w.length) {
            return 0;
        }
        int t = process(w, v, cur + 1, rest - w[cur]);
        int t1 = v[cur] + t;
        int t2 = process(w, v, cur + 1, rest);

        if (t < 0) {
            return t2;
        }
        return Math.max(t1, t2);
    }

    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, rest);
        int p2 = 0;
        int next = process(w, v, index + 1, rest - w[index]);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(process(weights, values, 0, bag));
        System.out.println(dpWay(weights, values, bag));
    }
}
