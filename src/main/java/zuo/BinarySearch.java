package zuo;

/**
 * @author zhangrucheng on 2023/4/11
 */
public class BinarySearch {

    private static int findValue(int[] sortArr, int target) {
        int index = -1;
        int L = 0, R = sortArr.length;
        while(L < R) {
            int M = ((R - L) >> 1) + L;
            if (sortArr[M] > target) {
                R = M;
            } else if (sortArr[M] == target) {
                index = M;
                break;
            } else {
                L = M + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,5,6,7,8,12,15,67,78};
        System.out.println(findValue(test, 15));
        System.out.println(findValue(test, 6));
        System.out.println(findValue(test, 61));
    }
}
