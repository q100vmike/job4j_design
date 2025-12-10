package algo;

public class QuickSort {

    public static int partition(int[] arr) {
        int pivot = arr[0];
        int beginToEnd = pivot + 1;
        int endToBegin = arr.length - 1;

            while (arr[beginToEnd] < pivot) {
                beginToEnd++;
            }
            while (arr[endToBegin] > pivot) {
                endToBegin--;
            }
        if (beginToEnd >= endToBegin) {

        }

    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {}
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 2, 7, 3, 4, 6, 9, 12};
        int i = partition(arr);
    }
}
