import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Напишите программу на Java,
 * которая копирует содержимое одного файла
 * в другой с использованием FileReader и FileWriter.
 */
public class FirstTask {

    public static final String FILE_NAME = "test.txt";
    public static void main(String[] args) {

        StringBuilder text = reader(FILE_NAME);

        write(text, "test2.txt");

    }

    public static StringBuilder reader(String fileName){
        StringBuilder text = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    public static void write(StringBuilder data, String fileName){
        try {
            FileWriter fileWriter =new FileWriter(fileName);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
