package msb.recurisive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangrucheng on 2023/3/31
 */
public class PrintAllSubSequences {

    public static List<String> printAllSubSequences(String s) {

        Set<String> ans = new HashSet<>();
        char[] arr = s.toCharArray();
        process2(arr, 0, "", ans);
        return new ArrayList<>(ans);
    }

    private static void process2(char[] arr, int index, String path, Set<String> ans) {
        if (index == arr.length) {
            ans.add(path);
            return;
        }

        process2(arr, index + 1, path + arr[index], ans);
        process2(arr, index + 1, path, ans);
    }

    private static void process(char[] arr, int index, String path, List<String> ans) {
        if (index == arr.length) {
            ans.add(path);
            return;
        }

        process(arr, index + 1, path + arr[index], ans);
        process(arr, index + 1, path, ans);
    }

    public static void main(String[] args) {
        List<String> ans = printAllSubSequences("abcc");
        ans.forEach(System.out::println);
    }
}
