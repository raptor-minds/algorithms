package geekTime.array;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0;
        while (i < matrix.length && matrix[0][i] <= target) {
            i++;
        }
        --i;
        while (j < matrix[0].length && matrix[j][i] <= target) {
            j++;
        }
        --j;
        return matrix[i][j] == target;
    }
}
