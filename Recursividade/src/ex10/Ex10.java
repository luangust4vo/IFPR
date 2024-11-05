package ex10;

import ex10.sort.BubbleSort;
import ex10.sort.InsertionSort;
import ex10.sort.MergeSort;
import ex10.sort.SelectionSort;

import java.util.Arrays;
import java.util.Random;

@FunctionalInterface
interface Callback {
    void execute();
}

public class Ex10 {
    public static void main(String[] args) {
        int[] lengths = {1000, 10000, 100000};

        for (int i : lengths) {
            int[] originalArray = generateRandomArray(i);

            double bubbleTime = calcTime(() -> {
                int[] array = originalArray.clone();
                BubbleSort.sort(array);
            });
            System.out.println("BubbleSort");
            System.out.println(i + ": " + bubbleTime + " segundos");

            double insertionTime = calcTime(() -> {
                int[] array = originalArray.clone();
                InsertionSort.sort(array);
            });
            System.out.println("InsertionSort");
            System.out.println(i + ": " + insertionTime + " segundos");

            double selectionTime = calcTime(() -> {
                int[] array = originalArray.clone();
                SelectionSort.sort(array);
            });
            System.out.println("SelectionSort");
            System.out.println(i + ": " + selectionTime + " segundos");

            double mergeTime = calcTime(() -> {
                int[] array = originalArray.clone();
                MergeSort.sort(array, new int[array.length], 0, array.length - 1);
            });
            System.out.println("MergeSort");
            System.out.println(i + ": " + mergeTime + " segundos");
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    /*
    * Só para eu conseguir chamar as funções como callback
    * Facilita pois agora eu não preciso chamar um System.nanoTime() para todas
    * individualmente
     */
    public static double calcTime(Callback callback) {
        long start = System.nanoTime(), end;
        callback.execute();
        end = System.nanoTime();

        return (double) ((end - start) / 1_000_000_000.0);
    }
}
