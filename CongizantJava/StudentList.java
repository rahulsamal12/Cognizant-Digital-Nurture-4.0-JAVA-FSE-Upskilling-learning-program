import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String choice;
        do {
            System.out.print("Enter student name: ");
            names.add(sc.nextLine());

            System.out.print("Do you want to add another name? (yes/no): ");
            choice = sc.nextLine().toLowerCase();
        } while (choice.equals("yes"));

        System.out.println("Student Names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
