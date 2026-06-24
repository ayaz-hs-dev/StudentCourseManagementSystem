package logic;

import data.FileManager;
import model.Course;
import java.util.*;

public class CourseManager {
    private final String fileName = "courses.txt";

    // Returns a list of Course objects (not raw String[])
    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        for (String line : FileManager.readAll(fileName)) {
            courses.add(Course.fromString(line));
        }
        return courses;
    }

    // Accepts a Course object; serializes it via toString() for file storage
    public void add(Course course) {
        List<String> lines = FileManager.readAll(fileName);
        lines.add(course.toString());
        FileManager.writeAll(fileName, lines);
    }

    // Accepts a Course object; replaces the record at the given index
    public void update(int index, Course course) {
        List<String> lines = FileManager.readAll(fileName);
        if (index >= 0 && index < lines.size()) {
            lines.set(index, course.toString());
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
