package ui;

import logic.CourseManager;
import model.Course;
import java.util.*;

public class CourseForm extends BaseManagementForm {

    private final CourseManager manager;

    public CourseForm() {
        super(
            "Course Management",
            new String[]{ "Course Code", "Course Title", "Credit Hours", "Department", "Instructor" },
            new String[]{ "Course Code", "Course Title", "Credit Hours", "Department", "Instructor" }
        );
        this.manager = new CourseManager();
        init();
    }

    @Override
    protected Object buildObject() {
        try {
            return new Course(
                fields[0].getText().trim(),
                fields[1].getText().trim(),
                Integer.parseInt(fields[2].getText().trim()),
                fields[3].getText().trim(),
                fields[4].getText().trim()
            );
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Credit Hours must be a whole number.");
            return null;
        }
    }

    @Override
    protected List<Object[]> loadRows() {
        List<Object[]> rows = new ArrayList<>();
        for (Course c : manager.getAll()) rows.add(c.toRow());
        return rows;
    }

    @Override protected void callAdd(Object obj)           { manager.add((Course) obj); }
    @Override protected void callUpdate(int i, Object obj) { manager.update(i, (Course) obj); }
    @Override protected void callDelete(int i)             { manager.delete(i); }
}
