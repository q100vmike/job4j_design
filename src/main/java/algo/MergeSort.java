package algo;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 1, 8, 2, 7, 3, 4, 6, 9, 12};
        int n = array.length;
        int i = 0;

        while (n > 1) {

            int[] left = Arrays.copyOfRange(array, 0, n / 2);
            int[] right = Arrays.copyOfRange(array, n / 2, n);

        }


    }
}
