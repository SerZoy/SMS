import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Remove Student");
            System.out.println("5. Clear All Data");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> manager.addStudent();
                case 2 -> manager.showAll();
                case 3 -> manager.findStudent();
                case 4 -> manager.removeStudent();
                case 5 -> manager.clearAllData();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}