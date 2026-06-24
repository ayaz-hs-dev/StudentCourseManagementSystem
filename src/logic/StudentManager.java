package logic;

import data.FileManager;
import model.Student;
import java.util.*;

public class StudentManager {
    private final String fileName = "students.txt";

    // Returns a list of Student objects (not raw String[])
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        for (String line : FileManager.readAll(fileName)) {
            students.add(Student.fromString(line));
        }
        return students;
    }

    // Accepts a Student object; serializes it via toString() for file storage
    public void add(Student student) {
        List<String> lines = FileManager.readAll(fileName);
        lines.add(student.toString());
        FileManager.writeAll(fileName, lines);
    }

    // Accepts a Student object; replaces the record at the given index
    public void update(int index, Student student) {
        List<String> lines = FileManager.readAll(fileName);
        if (index >= 0 && index < lines.size()) {
            lines.set(index, student.toString());
            FileManager.writeAll(fileName, lines);
        }
    }

    public void delete(int index) {
        List<String> lines = FileManager.readAll(fileName);
        if (index >= 0 && index < lines.size()) {
            lines.remove(index);
            FileManager.writeAll(fileName, lines);
        }
    }
}
