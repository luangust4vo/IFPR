package ex10.sort;

public class BubbleSort {
    public static void sort(int[] array) {
        // long startTime = System.nanoTime(), endTime;
        int len = array.length - 1;

        boolean controller = true;
        while (controller) {
            controller = false;

            for(int i = 0; i < len; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    controller = true;
                }
            }
        }

        // endTime = System.nanoTime();

        // return (endTime - startTime);
    }
}