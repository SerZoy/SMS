import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "students.txt";

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent() {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Dept: "); String dept = sc.nextLine();
        System.out.print("CGPA: "); double cg = sc.nextDouble();

        Student s = new Student(id, name, dept, cg);
        students.add(s);
        saveToFile();
        System.out.println("Student added successfully!");
    }

    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("No students yet!");
            return;
        }
        for (Student s : students) System.out.println(s);
        System.out.println("=======================");
    }

    public void findStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found!" + s +"\n=======================");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void removeStudent() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                saveToFile();
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }


    public void clearAllData() {
        System.out.println("Are you sure? (Y/N)");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")|| confirm.equalsIgnoreCase("y")){
        students.clear();
        saveToFile();
        System.out.println("All student data cleared!");
        }
        else return;
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.getId() + "," + s.getName() + "," + s.getDept() + "," + s.getCgpa());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String dept = parts[2];
                    double cg = Double.parseDouble(parts[3]);
                    students.add(new Student(id, name, dept, cg));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
