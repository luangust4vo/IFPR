package ex4;
// Implemente uma função recursiva que retorne o n-ésimo termo da sequência de Fibonacci.

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        System.out.printf("O %d° termo da sequência de Fibonacci é %d", n, nTermOfFibonacci(n));

        scan.close();
    }

    public static int nTermOfFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        else return nTermOfFibonacci(n - 1) + nTermOfFibonacci(n - 2);
    }
}
