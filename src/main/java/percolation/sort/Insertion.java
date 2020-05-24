package percolation.sort;

import com.sun.tools.javac.util.Assert;

public class Insertion extends SortBase implements Sort {

    @Override
    public void sort(Comparable[] a, boolean needPrint) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exec(j, j-1, a);
                    show(a, i + 1, needPrint);
                }
            }
            show(a, i + 1, needPrint);
        }
    }

    public static void main(String[] args) {
        Double[] a = (Double[]) init();
        Insertion insertion = new Insertion();
        insertion.sort(a, true);
        Assert.check(isSorted(a));
    }

}
