import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 4, 5, 1, -1, -7, 22};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
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
}