import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        String choice;
        do {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);

            System.out.print("Do you want to add another student? (yes/no): ");
            choice = scanner.nextLine().toLowerCase();
        } while (choice.equals("yes"));

        System.out.print("Enter ID to search: ");
        int searchId = Integer.parseInt(scanner.nextLine());

        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
