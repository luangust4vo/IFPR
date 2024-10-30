package ex8;
// Implemente o Merge Sort para ordenar um array de objetos com base em um 
// atributo específico (por exemplo, idade de uma pessoa).

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex8 {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice", "1990-05-20"),
            new Person("Bob", "1985-03-15"),
            new Person("Charlie", "2000-12-10"),
            new Person("Diana", "1995-07-25")
        };
        Person[] aux = new Person[people.length];
        mergeSort(people, aux, 0, people.length - 1);

        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

    private static void mergeSort(Person[] people, Person[] aux, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(people, aux, start, middle);
			mergeSort(people, aux, middle + 1, end);
            merge(people, aux, start, middle, end);
		}
	}

	private static void merge(Person[] people, Person[] aux, int start, int middle, int end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		for (int x = start; x <= end; x++) {
			aux[x] = people[x];
		}

		int left = start;
		int right = middle + 1;

		for (int x = start; x <= end; x++) {
			if (left > middle) {
				people[x] = aux[right++];
			} else if (right > end) {
				people[x] = aux[left++];
			} else {
                LocalDate leftDate = LocalDate.parse(aux[left].getBirthDate(), formatter);
                LocalDate rightDate = LocalDate.parse(aux[right].getBirthDate(), formatter);
                
                if (leftDate.isBefore(rightDate)) {
                    people[x] = aux[left++];
                } else {
                    people[x] = aux[right++];
                }
            }
		}
	}
}
