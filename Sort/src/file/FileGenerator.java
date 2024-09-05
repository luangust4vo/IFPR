package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    public static void main(String[] args) {
        String fileName = "example100k.txt";
        Integer[] vetor = new Integer[20900]; // 2000 = 10k // 20900 = 100k // 209290 = 1m
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(1000);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("{");
            for (int i = 0; i < vetor.length; i++) {
                writer.write(String.valueOf(vetor[i]));
                if(i<vetor.length - 1){
                    writer.write(", ");
                }
            }
            writer.write("}");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}