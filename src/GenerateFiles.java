import java.io.*;
import java.util.Random;

public class GenerateFiles {
    public static void main(String[] args) {
        int fileCount = 100;
        double numbersCount;


        Random rand = new Random();

        for (int i = 1; i <= fileCount; i++) {
            numbersCount = Math.random() * 9900 + 100;
            String fileName = "data_input_" + i + ".txt";
            File file = new File("Sem_1/src/input_data", fileName);
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (int j = 0; j < numbersCount; j++) {
                    writer.println(rand.nextInt(1000));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}