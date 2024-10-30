package ex6;
// Faça uma função recursiva para inverter uma string.

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe uma palavra ou frase");
        String w = scan.nextLine();

        System.out.println("Essa é a palavra/frase informada, mas invertida: " + invertString(w));

        scan.close();
    }

    public static String invertString(String w) {
        if (w.length() == 0) return w;
        else return invertString(w.substring(1)) + w.charAt(0);
    }
}
