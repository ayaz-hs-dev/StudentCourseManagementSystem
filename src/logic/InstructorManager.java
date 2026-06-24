package logic;

import data.FileManager;
import model.Instructor;
import java.util.*;

public class InstructorManager {
    private final String fileName = "instructors.txt";

    // Returns a list of Instructor objects (not raw String[])
    public List<Instructor> getAll() {
        List<Instructor> instructors = new ArrayList<>();
        for (String line : FileManager.readAll(fileName)) {
            instructors.add(Instructor.fromString(line));
        }
        return instructors;
    }

    // Accepts an Instructor object; serializes it via toString() for file storage
    public void add(Instructor instructor) {
        List<String> lines = FileManager.readAll(fileName);
        lines.add(instructor.toString());
        FileManager.writeAll(fileName, lines);
    }

    // Accepts an Instructor object; replaces the record at the given index
    public void update(int index, Instructor instructor) {
        List<String> lines = FileManager.readAll(fileName);
        if (index >= 0 && index < lines.size()) {
            lines.set(index, instructor.toString());
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
