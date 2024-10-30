package ex9;

import java.util.Arrays;

public class Ex9 {
    public static void main(String[] args) {
        String[] words = {"zebra", "elefante", "arara", "macaco", "leão"};
        String[] aux = new String[words.length];

        mergeSort(words, aux, 0, words.length - 1);

        System.out.println(Arrays.toString(words));
    }

    private static void mergeSort(String[] words, String[] aux, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(words, aux, start, middle);
			mergeSort(words, aux, middle + 1, end);
            merge(words, aux, start, middle, end);
		}
	}

	private static void merge(String[] words, String[] aux, int start, int middle, int end) {
		for (int x = start; x <= end; x++) {
			aux[x] = words[x];
		}

		int left = start;
		int right = middle + 1;

		for (int x = start; x <= end; x++) {
			if (left > middle) {
				words[x] = aux[right++];
			} else if (right > end) {
				words[x] = aux[left++];
			} else if (aux[left].compareTo(aux[right]) < 0) {
				words[x] = aux[left++];
			} else {
				words[x] = aux[right++];
			}
		}
	}
}
