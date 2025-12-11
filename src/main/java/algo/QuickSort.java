package algo;

public class QuickSort {

    public static void qsort(int[] arr, int beginToEnd, int endToBegin) {
        int pivot = beginToEnd;
        beginToEnd = pivot + 1;
//        int endToBegin = arr.length - 1;

        while (beginToEnd <= endToBegin) {

            while (arr[pivot] > arr[beginToEnd]) {
                beginToEnd++;
            }
            while (arr[pivot] < arr[endToBegin]) {
                endToBegin--;
            }
            if (beginToEnd >= endToBegin) {
                swap(arr, beginToEnd, pivot);
            } else {
                swap(arr, beginToEnd, endToBegin);
            }

            beginToEnd++;
            endToBegin--;
        }
        qsort(arr, 0, endToBegin);
        qsort(arr, endToBegin, arr.length - 1);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

//    public static void sort(int[] arr, int left, int right) {
//        if (left < right) {}
//    }
    private static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        // Случайный выбор опорного элемента для лучшей производительности
        int pivotIndex = 0; //ThreadLocalRandom.current().nextInt(begin, end + 1);
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, end);

        int storeIndex = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, end);

        quickSort(arr, begin, storeIndex - 1);
        quickSort(arr, storeIndex + 1, end);
    }
    public static void main(String[] args) {
        //int[] arr = {5, 1, 8, 2, 7, 3, 4, 6, 9, 12};
        int[] arr = {5, 1, 8, 2};
        //quickSort(arr, begin, end);
        qsort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }
}
