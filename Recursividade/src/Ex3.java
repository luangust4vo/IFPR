import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe uma palavra e uma letra, verifique quantas vezes a letra aparece na palaravra");
        System.out.println("Palavra: ");
        String word = scan.nextLine();
        System.out.println("Letra: ");
        char letter = scan.nextLine().charAt(0);

        System.out.printf("A letra %c aparece %d vezes na palavra %s", letter, countOccurrences(word, letter, 0), word);

        scan.close();
    }

    public static int countOccurrences(String word, char letter, int index) {
        if (index <= 0) return 0;
        else if (word.charAt(index) == letter) return 1;

        return countOccurrences(word, letter, index) + countOccurrences(word, letter, index + 1);
    }
}
