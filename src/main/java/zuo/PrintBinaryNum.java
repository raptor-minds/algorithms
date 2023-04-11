package zuo;

/**
 * @author zhangrucheng on 2023/4/11
 */
public class PrintBinaryNum {

    private static void printBinary(int num) {
        for (int i = 31; i >= 0 ; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0": "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printBinary(8);
    }
}
