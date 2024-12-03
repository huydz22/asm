import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    public String getRank() {
        if (marks >= 9.0) return "Excellent";
        if (marks >= 7.5) return "Very Good";
        if (marks >= 6.5) return "Good";
        if (marks >= 5.0) return "Medium";
        return "Fail";
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Marks: %.2f, Rank: %s", id, name, marks, getRank());
    }
}

public class Bubblesort {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Stack<Student> stack = new Stack<>();  // Khai báo Stack để lưu trữ sinh viên
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Display All Students");
            System.out.println("7. Push Student to Stack");
            System.out.println("8. Pop Student from Stack");
            System.out.println("9. Peek Top Student");
            System.out.println("10. Check If Stack is Empty");
            System.out.println("11. Display Stack");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> deleteStudent();
                case 4 -> sortStudents();
                case 5 -> searchStudent();
                case 6 -> displayStudents();
                case 7 -> pushStudentToStack();
                case 8 -> popStudentFromStack();
                case 9 -> peekTopStudent();
                case 10 -> checkIfStackIsEmpty();
                case 11 -> displayStack();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = Double.parseDouble(scanner.nextLine());

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new Student Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new Student Marks: ");
                student.setMarks(Double.parseDouble(scanner.nextLine()));
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        students.removeIf(student -> student.getId().equals(id));
        System.out.println("Student deleted successfully.");
    }

    private static void sortStudents() {
        // Thuật toán Bubble Sort để sắp xếp sinh viên theo điểm
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Students sorted by marks.");
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Thêm sinh viên vào Stack
    private static void pushStudentToStack() {
        System.out.print("Enter Student ID to push to stack: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                stack.push(student);  // Thêm sinh viên vào Stack
                System.out.println("Student pushed to stack.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Loại bỏ sinh viên khỏi Stack
    private static void popStudentFromStack() {
        if (!stack.isEmpty()) {
            Student student = stack.pop();  // Lấy và loại bỏ sinh viên ở đỉnh Stack
            System.out.println("Popped Student: " + student);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    // Xem sinh viên ở đỉnh Stack mà không loại bỏ
    private static void peekTopStudent() {
        if (!stack.isEmpty()) {
            Student student = stack.peek();  // Xem sinh viên ở đỉnh Stack
            System.out.println("Top Student: " + student);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    // Kiểm tra Stack có rỗng không
    private static void checkIfStackIsEmpty() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack is not empty.");
        }
    }

    // Hiển thị tất cả sinh viên trong Stack
    private static void displayStack() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Students in stack:");
            for (Student student : stack) {
                System.out.println(student);
            }
        }
    }
}
