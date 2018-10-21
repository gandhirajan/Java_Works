import java.util.Arrays;
/* Java class to merge two arrays of size m and n into one array with m+n complexity */
public class ArrayMergeSorter {

    private static void sortedMerge(int a[], int b[], int res[], int n, int m) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i += 1;
                k += 1;
            } else {
                res[k] = b[j];
                j += 1;
                k += 1;
            }
        }

        while (i < n) {
            res[k] = a[i];
            i += 1;
            k += 1;
        }
        while (j < m) {
            res[k] = b[j];
            j += 1;
            k += 1;
        }
    }

   public static void main(String[] args) {
        int a[] = {10, 5, 15};
        int b[] = {20, 3, 2, 12};
        int n = a.length;
        int m = b.length;

        int res[] = new int[n + m];
        sortedMerge(a, b, res, n, m);

        for (int i = 0; i < n + m; i++)
            System.out.print(" " + res[i]);
    }

}
