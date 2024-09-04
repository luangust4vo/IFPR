package bubblesort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 1, -1, -7, 22};
        bubbleSort(array);
        System.out.println("Array of integers sorted: " + Arrays.toString(array));

        String[] dates = {"2024-09-04", "2024-09-03", "2021-03-07", "2024-09-02"};
        bubbleSort(dates);
        System.out.println("Array of dates sorted: " + Arrays.toString(dates));
    }

    public static void bubbleSort(int[] array) {
        int len = array.length;

        boolean sorted = false;
        while (!sorted) {
            sorted = true;

            for (int i = 0; i < len-1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void bubbleSort(String[] array) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate[] dates = new LocalDate[array.length];
        for (int i = 0; i < array.length; i++) {
            dates[i] = LocalDate.parse(array[i], formatter);
        }

        boolean sorted = false;
        while(!sorted) {
            sorted = true;

            for (int i = 0; i < array.length-1; i++) {
                if (dates[i].isAfter(dates[i+1])) {
                    LocalDate temp = dates[i];
                    dates[i] = dates[i+1];
                    dates[i+1] = temp;

                    array[i] = dates[i].format(formatter);
                    array[i+1] = dates[i+1].format(formatter);

                    sorted = false;
                }
            }
        }
    }
}
