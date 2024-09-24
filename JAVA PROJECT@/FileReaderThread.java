import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderThread extends Thread {
    private List<Student> students = new ArrayList<>();
    private String inputFile;

    public FileReaderThread(String inputFile) {
        this.inputFile = inputFile;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming file format: name,age,rollNumber,marks
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int rollNumber = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);
                
                // Create a new student and add to the list
                Student student = new Student(name, age, rollNumber, marks);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
