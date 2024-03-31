package sort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        File inputData = new File("Sem_1/src/input_data");
        File results = new File("Sem_1/src/results.txt");

        results.createNewFile();

        FileWriter writer = new FileWriter("Sem_1/src/results.txt");
        PrintWriter printer = new PrintWriter(writer);
        printer.println("Файл\tИтерации\tВремя\tРазмер массива");



        File[] testsData = inputData.listFiles(); // массив со всеми входными данными
        for (File file: testsData){

            String name = file.getName();
            List<Integer> numbersList = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int number = Integer.parseInt(line.trim());
                numbersList.add(number);

            }

            int[] numbersArray = new int[numbersList.size()];
            for (int i = 0; i < numbersList.size(); i++) {
                numbersArray[i] = numbersList.get(i);
            }

            PancakeSort sorter = new PancakeSort();
            int len = numbersArray.length;
            long start_time = System.nanoTime();
            sorter.pancakeSort(numbersArray, len);
            long iterations = sorter.iters; // число итераций
            long end_time = System.nanoTime();
            long time = end_time - start_time; // время работы алгоритма
            printer.println(String.format("%s\t%d\t%d\t%d", name, iterations, time, len));

        }
    }
}