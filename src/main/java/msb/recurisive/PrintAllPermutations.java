package msb.recurisive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrucheng on 2023/3/31
 */
public class PrintAllPermutations {

    public static List<String> printAllPermutations(String s) {
        char[] arr = s.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Character> rest = new ArrayList<>();
        for (Character c : arr) {
            rest.add(c);
        }
        process1(arr, 0, "", ans);
        return ans;
    }

    private static void process1(char[] arr, int index, String path, List<String> ans) {
        if (index == arr.length) {
            ans.add(path);
            return;
        }

        // visited 这边需要注意，之前想错了
        boolean[] visited = new boolean[256];
        for (int i = index; i < arr.length; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                swap(arr, index, i);
                process1(arr, index + 1, path + arr[index], ans);
                swap(arr, index, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void process(List<Character> rest, String path, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(path);
            return;
        }

        for (int i = 0; i < rest.size(); i++) {
            char c = rest.get(i);
            rest.remove(i);
            process(rest, path + c, ans);
            rest.add(i, c);
        }
    }

    public static void main(String[] args) {
        List<String> ans = printAllPermutations("acc");
        ans.forEach(System.out::println);
    }
}
