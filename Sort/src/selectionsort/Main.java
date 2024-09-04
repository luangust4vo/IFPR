package selectionsort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 1, -1, -7, 22};
        selectionSort(array);
        System.out.println("Array of integers sorted: " + Arrays.toString(array));

        String[] dates = {"2024-09-04", "2024-09-03", "2021-03-07", "2024-09-02"};
        selectionSort(dates);
        System.out.println("Array of dates sorted: " + Arrays.toString(dates));
    }

    public static void selectionSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            int smallerIndex = i;
            for (int j = smallerIndex + 1; j < len; j++) {
                if (array[j] < array[smallerIndex]) {
                    smallerIndex = j;
                }
            }

            if (smallerIndex != i) {
                int temp = array[i];
                array[i] = array[smallerIndex];
                array[smallerIndex] = temp;
            }
        }
    }

    public static void selectionSort(String[] array) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate[] dates = new LocalDate[array.length];
        for (int i = 0; i < array.length; i++) {
            dates[i] = LocalDate.parse(array[i], formatter);
        }

        for (int i = 0; i < array.length; i++) {
            int smallerIndex = i;
            for (int j = smallerIndex + 1; j < array.length; j++) {
                if (dates[j].isBefore(dates[smallerIndex])) {
                    smallerIndex = j;
                }
            }

            if (smallerIndex != i) {
                LocalDate temp = dates[smallerIndex];
                dates[smallerIndex] = dates[i];
                dates[i] = temp;

                array[smallerIndex] = dates[smallerIndex].format(formatter);
                array[i] = dates[i].format(formatter);
            }
        }
    }
}