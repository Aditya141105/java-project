import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int studentCount = scanner.nextInt();

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            // Collecting student details
            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Roll Number: ");
            int rollNumber = scanner.nextInt();

            int[] marks = new int[5];
            int[] credits = {4, 3, 4, 2, 4}; // Credit points for each subject
            
            System.out.print("Enter marks for JAVA PROGRAMMING (4 Credit): ");
            marks[0] = scanner.nextInt();
            System.out.print("Enter marks for MPCO (3 Credit): ");
            marks[1] = scanner.nextInt();
            System.out.print("Enter marks for DSA (4 Credit): ");
            marks[2] = scanner.nextInt();
            System.out.print("Enter marks for CPI (2 Credit): ");
            marks[3] = scanner.nextInt();
            System.out.print("Enter marks for Mathematics (4 Credit): ");
            marks[4] = scanner.nextInt();
             
            // Create a new Student object and add it to the list
            Student student = new Student(name, age, rollNumber, marks, credits);
            students.add(student);
        }

        // Save the processed student data to a file
        saveStudentDataToFile(students, "DATA/processed_students.txt");

        System.out.println("\nStudent details and grades saved to processed_students.txt.");
    }

    private static void saveStudentDataToFile(List<Student> students, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.write("Name: " + student.getName() +
                             "\nAge: " + student.getAge() +
                             "\nRoll Number: " + student.getRollNumber() +
                             "\nAverage Marks: " + student.getAverageMarks() +
                             "\nSGPA: " + student.getSGPA() +
                             "\nGrade: " + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
