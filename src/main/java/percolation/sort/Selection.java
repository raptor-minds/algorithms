package percolation.sort;

import com.sun.tools.javac.util.Assert;

public class Selection extends SortBase implements Sort {

    @Override
    public void sort(Comparable[] a, boolean needPrint) {
        for (int i = 0; i < a.length; i++) {
            Comparable min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[i])) {
                    exec(j, i, a);
                    show(a, i + 1, needPrint);
                }
            }
            show(a, i + 1, needPrint);
        }
    }

    public static void main(String[] args) {
        Double[] a = (Double[]) init();
        Selection selection = new Selection();
        selection.sort(a, true);
        Assert.check(isSorted(a));
    }
}
