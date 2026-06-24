package logic;

import data.FileManager;
import model.Grade;
import java.util.*;

public class GradeManager {
    private final String fileName = "grades.txt";

    // Returns a list of Grade objects (not raw String[])
    public List<Grade> getAll() {
        List<Grade> grades = new ArrayList<>();
        for (String line : FileManager.readAll(fileName)) {
            grades.add(Grade.fromString(line));
        }
        return grades;
    }

    // Accepts a Grade object; serializes it via toString() for file storage
    public void add(Grade grade) {
        List<String> lines = FileManager.readAll(fileName);
        lines.add(grade.toString());
        FileManager.writeAll(fileName, lines);
    }

    // Accepts a Grade object; replaces the record at the given index
    public void update(int index, Grade grade) {
        List<String> lines = FileManager.readAll(fileName);
        if (index >= 0 && index < lines.size()) {
            lines.set(index, grade.toString());
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
