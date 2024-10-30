package ex10.sort;

public class InsertionSort {
    public static void sort(int[] array) {
        int len = array.length;

        for(int i = 1; i < len; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
