public class Student extends Person {
    private int rollNumber;
    private int[] marks;
    private int[] credits;
    private String[] grades;
    private double[] gradePoints;
    private double sgpa;
    private double averageMarks;

    // Constructor
    public Student(String name, int age, int rollNumber, int[] marks, int[] credits) {
        super(name, age);
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.credits = credits;
        this.grades = new String[5];
        this.gradePoints = new double[5];
        this.averageMarks = calculateAverageMarks();
        this.sgpa = calculateSGPA();
    }

    // Getter methods
    public int getRollNumber() {
        return rollNumber;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public double getSGPA() {
        return sgpa;
    }

    public String getGrade() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grades.length; i++) {
            sb.append("Subject ").append(i + 1).append(" Grade: ").append(grades[i])
              .append(", Grade Points: ").append(gradePoints[i]).append("\n");
        }
        return sb.toString();
    }

    // Calculate average marks
    private double calculateAverageMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / 5.0;  // Calculate the average of 5 subjects
    }

    // Calculate SGPA based on grades and credits
    private double calculateSGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < marks.length; i++) {
            gradePoints[i] = calculateGradePoint(marks[i]);
            grades[i] = calculateGrade(marks[i]);
            totalGradePoints += gradePoints[i] * credits[i];
            totalCredits += credits[i];
        }
        return totalGradePoints / totalCredits;
    }

    // Calculate the grade based on marks
    private String calculateGrade(int marks) {
        if (marks >= 80) return "AA";
        if (marks >= 73) return "AB";
        if (marks >= 66) return "BB";
        if (marks >= 60) return "BC";
        if (marks >= 55) return "CC";
        if (marks >= 50) return "CD";
        if (marks >= 45) return "DD";
        return "F";
    }

    // Calculate the grade points based on marks
    private double calculateGradePoint(int marks) {
        if (marks >= 80) return 10.0;
        if (marks >= 73) return 9.0;
        if (marks >= 66) return 8.0;
        if (marks >= 60) return 7.0;
        if (marks >= 55) return 6.0;
        if (marks >= 50) return 5.0;
        if (marks >= 45) return 4.0;
        return 0.0;
    }
}
