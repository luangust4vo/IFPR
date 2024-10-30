package ex7;
import java.util.Arrays;

public class Ex7 {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (int) (Math.random() * 100);
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Ordenado:");
        for (int[] row : matrix) {
            mergeSort(row, new int[row.length], 0, row.length - 1);
            System.out.println(Arrays.toString(row));
        }
    }

    private static void mergeSort(int array[], int aux[], int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(array, aux, start, middle);
			mergeSort(array, aux, middle + 1, end);
            merge(array, aux, start, middle, end);
		}
	}

	private static void merge(int[] array, int[] aux, int start, int middle, int end) {
		for (int x = start; x <= end; x++) {
			aux[x] = array[x];
		}

		int left = start;
		int right = middle + 1;

		for (int x = start; x <= end; x++) {
			if (left > middle) {
				array[x] = aux[right++];
			} else if (right > end) {
				array[x] = aux[left++];
			} else if (aux[left] < aux[right]) {
				array[x] = aux[left++];
			} else {
				array[x] = aux[right++];
			}
		}
	}
}
