import java.io.*;
import java.util.List;

public class FileWriterThread extends Thread {
    private List<Student> students;
    private String outputFile;

    public FileWriterThread(List<Student> students, String outputFile) {
        this.students = students;
        this.outputFile = outputFile;
    }

    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Student student : students) {
                bw.write(student.getName() + "," + student.getAge() + "," +
                         student.getRollNumber() + "," + student.getMarks() + "," +
                         student.getGrade());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
