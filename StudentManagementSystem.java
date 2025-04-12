import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Marks: ");
        int marks = sc.nextInt();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                s.display();
            }
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine(); // Consume newline
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Marks: ");
                s.marks = sc.nextInt();
                System.out.println("Student details updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }
}
