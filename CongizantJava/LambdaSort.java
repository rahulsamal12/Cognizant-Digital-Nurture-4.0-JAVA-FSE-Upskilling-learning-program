import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sourav", "Ankit", "Padman", "Tushar");

        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println("Sorted List: " + names);
    }
}
