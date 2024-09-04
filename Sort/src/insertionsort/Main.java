package insertionsort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 1, -1, -7, 22};
        insertionSort(array);
        System.out.println("Array of integers sorted: " + Arrays.toString(array));

        String[] dates = {"2024-09-04", "2024-09-03", "2021-03-07", "2024-09-02"};
        insertionSort(dates);
        System.out.println("Array of dates sorted: " + Arrays.toString(dates));
    }

    public static void insertionSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            int current = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void insertionSort(String[] array) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate[] dates = new LocalDate[array.length];
        for (int i = 0; i < array.length; i++) {
            dates[i] = LocalDate.parse(array[i], formatter);
        }

        for (int i = 0; i < array.length; i++) {
            LocalDate current = dates[i];
            int j = i - 1;

            while(j >= 0 && dates[j].isAfter(current)) {
                dates[j + 1] = dates[j];
                array[j + 1] = dates[j + 1].format(formatter);
                j--;
            }
            dates[j + 1] = current;
            array[j + 1] = current.format(formatter);
        }
    }
}
