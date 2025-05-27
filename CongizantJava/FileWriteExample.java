import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to write to file: ");
        String input = sc.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(input);
            System.out.println("Data has been written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }
    }
}
