import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.print("Enter your choice: ");
                }
            }

            switch (choice) {
                case 1:
                    addStudent(scanner, system);
                    break;
                case 2:
                    removeStudent(scanner, system);
                    break;
                case 3:
                    searchStudent(scanner, system);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        int rollNumber;
        while (true) {
            System.out.print("Enter roll number: ");
            try {
                rollNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Roll number must be an integer.");
            }
        }

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine().trim();
        if (grade.isEmpty()) {
            System.out.println("Grade cannot be empty.");
            return;
        }

        system.addStudent(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully.");
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem system) {
        int rollNumber;
        while (true) {
            System.out.print("Enter roll number of student to remove: ");
            try {
                rollNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Roll number must be an integer.");
            }
        }

        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem system) {
        int rollNumber;
        while (true) {
            System.out.print("Enter roll number of student to search: ");
            try {
                rollNumber = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Roll number must be an integer.");
            }
        }

        Student searchedStudent = system.searchStudent(rollNumber);
        if (searchedStudent != null) {
            System.out.println("Student found: " + searchedStudent);
        } else {
            System.out.println("Student not found.");
        }
    }
}
