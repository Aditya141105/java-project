import java.util.List;

public class DataProcessorThread extends Thread {
    private List<Student> students;

    public DataProcessorThread(List<Student> students) {
        this.students = students;
    }

    public void run() {
        for (Student student : students) {
            // Process each student (e.g., calculate grade)
            int marks = student.getMarks();
            student.setGrade(calculateGrade(marks));
        }
    }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "AA";
        if (marks >= 80) return "AB";
        if (marks >= 70) return "BB";
        if (marks >= 60) return "BC";
        if (marks >= 50) return "CC";
        if (marks >= 40) return "CD";
        if (marks >= 33) return "DD";
    
        return "F";
    }
    
}
