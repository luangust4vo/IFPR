// Implemente uma função recursiva que verifique se uma string é um palíndromo.

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word;

        System.out.println("Digite uma palavra/frase e veja se é um palíndromo: ");
        word = formatWord(scan.nextLine());

        if (isPalindrome(word)) {
            System.out.println("Sim, a palavra/frase informada é um palíndromo");
        } else {
            System.out.println("Não, essa palavra/frase não é um palíndromo");
        }

        scan.close();
    }

    public static boolean isPalindrome(String word) {
        if (word.isEmpty() || word.length() == 1) return true;
        else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalindrome(word.substring(1, word.length() - 1));
        }

        return false;
    }

    public static String formatWord(String word) {
        return word.replace(" ", "").replace("-", "").toLowerCase();
    }
}