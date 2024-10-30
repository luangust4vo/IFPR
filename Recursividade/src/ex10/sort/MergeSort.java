package ex10.sort;

public class MergeSort {
    public static void sort(int[] array, int[] aux, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(array, aux, start, middle);
            sort(array, aux, middle + 1, end);
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
