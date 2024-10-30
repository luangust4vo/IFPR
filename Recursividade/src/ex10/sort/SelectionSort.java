package ex10.sort;

public class SelectionSort {
    public static void sort(int[] array) {
        int len = array.length - 1;

        for(int i = 0; i <= len; i++) {
            int smaller = i;
            for(int j = i; j <= len; j++) {
                if (array[j] < array[smaller]) {
                    smaller = j;
                }
            }

            if (smaller != i) {
                int temp = array[smaller];
                array[smaller] = array[i];
                array[i] = temp;
            }
        }
    }
}
