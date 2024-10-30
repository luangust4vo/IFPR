package ex5;
// Escreva uma função recursiva para calcular a soma dos dígitos de um número inteiro.

public class Ex5 {
    public static void main(String[] args) {
        System.out.println(somaDigitos(1234)); 
    }

    public static int somaDigitos(int n) {
        if (n < 10) { // Se for menor que 10, vai ser o próprio número
            return n;
        } else {
            /*
            Caso n seja maior que 10:
            -> n % 10 pega o último dígito do número
            -> n / 10 pega o número sem o último dígito
            -> o parâmetro da função é n / 10, ou seja, o número sem o último dígito
            -> a função vai ser chamada até que n seja menor que 10
            */ 
            return n % 10 + somaDigitos(n / 10);
        }
    }
}
