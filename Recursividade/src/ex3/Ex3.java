package ex3;
// Crie uma função recursiva para contar a ocorrência de um determinado caractere em uma string.

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe uma palavra e uma letra, verifique quantas vezes a letra aparece na palaravra");
        System.out.println("Palavra: ");
        String word = scan.nextLine();
        System.out.println("Letra: ");
        char letter = scan.nextLine().charAt(0);

        System.out.printf("A letra %c aparece %d vezes na palavra %s", letter, countOccurrences(word, letter), word);

        scan.close();
    }

    public static int countOccurrences(String word, char letter) {
        if (word.length() == 0) {
            return 0;
        }

        if (word.charAt(0) == letter) {
            return 1 + countOccurrences(word.substring(1), letter);
        }

        // Se a o primeiro caractere não for a letra procurada, chama novamente
        // tirando esse primeiro caractere, mas sem somar 
        return countOccurrences(word.substring(1), letter);
    }
}
