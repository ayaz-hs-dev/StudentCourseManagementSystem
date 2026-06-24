package logic;

import data.FileManager;
import model.Enrollment;
import java.util.*;

public class EnrollmentManager {
    private final String fileName = "enrollments.txt";

    // Returns a list of Enrollment objects (not raw String[])
    public List<Enrollment> getAll() {
        List<Enrollment> enrollments = new ArrayList<>();
        for (String line : FileManager.readAll(fileName)) {
            enrollments.add(Enrollment.fromString(line));
        }
        return enrollments;
    }

    // Accepts an Enrollment object; serializes it via toString() for file storage
    public void add(Enrollment enrollment) {
        List<String> lines = FileManager.readAll(fileName);
        lines.add(enrollment.toString());
        FileManager.writeAll(fileName, lines);
    }

    // Accepts an Enrollment object; replaces the record at the given index
    public void update(int index, Enrollment enrollment) {
        List<String> lines = FileManager.readAll(fileName);
        if (index >= 0 && index < lines.size()) {
            lines.set(index, enrollment.toString());
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
