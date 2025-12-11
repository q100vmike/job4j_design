package algo;

public class ClassicQuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Индекс опорного элемента после разделения
            int pivotIndex = zpartition(array, low, high);
            low++;
            // Рекурсивно сортируем элементы до и после опорного
            quickSort(array, low, pivotIndex - 1);
           // quickSort(array, pivotIndex + 1, high);
        }
    }
    private static int zpartition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = 0;
        if (low < high) {
            while (array[low] > array[i + 1]) {
                i++;
            }
            if (i > 0) {
                swap(array, low, i);
            }

        }
        return i;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int partition(int[] array, int low, int high) {
        // Выбираем опорный элемент (последний элемент)
        int pivot = array[high];

        // Индекс меньшего элемента
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (array[j] <= pivot) {
                i++;

                // Меняем местами array[i] и array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Меняем местами опорный элемент с элементом на позиции i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 9, 8, 5, 11};
        System.out.println("Исходный массив:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
