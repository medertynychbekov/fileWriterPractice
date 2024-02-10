import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Напишите программу на Java,
 * которая объединяет содержимое
 * нескольких файлов в один файл с
 * использованием FileReader и FileWriter.
 */
public class SecondTask {

    public static void main(String[] args) {

        StringBuilder data = new StringBuilder();

        reader(data, "test.txt"); // data -> test.txt(this is first text)
        data.append("\n"); // data -> test.txt(this is first text + \n)

        reader(data, "test2.txt"); // data -> test2.txt(this is second text)

                                            // data -> this is first text
                                            // data -> this is second text
        writer(data, "test3.txt"); // test3.txt -> data()

    }

    public static void reader(StringBuilder data, String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writer(StringBuilder data, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
