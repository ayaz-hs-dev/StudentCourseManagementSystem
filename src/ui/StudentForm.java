package ui;

import logic.StudentManager;
import model.Student;
import java.util.*;

public class StudentForm extends BaseManagementForm {

    private final StudentManager manager;

    public StudentForm() {
        super(
            "Student Management",
            new String[]{ "Student ID", "Name", "Email", "Phone", "Department", "Semester" },
            new String[]{ "Student ID", "Name", "Email", "Phone", "Department", "Semester" }
        );
        // Manager is assigned HERE, after super() has finished building the UI
        this.manager = new StudentManager();
        // Now it is safe to load data and show the window
        init();
    }

    @Override
    protected Object buildObject() {
        try {
            return new Student(
                fields[0].getText().trim(),
                fields[1].getText().trim(),
                fields[2].getText().trim(),
                fields[3].getText().trim(),
                fields[4].getText().trim(),
                Integer.parseInt(fields[5].getText().trim())
            );
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Semester must be a whole number.");
            return null;
        }
    }

    @Override
    protected List<Object[]> loadRows() {
        List<Object[]> rows = new ArrayList<>();
        for (Student s : manager.getAll()) rows.add(s.toRow());
        return rows;
    }

    @Override protected void callAdd(Object obj)           { manager.add((Student) obj); }
    @Override protected void callUpdate(int i, Object obj) { manager.update(i, (Student) obj); }
    @Override protected void callDelete(int i)             { manager.delete(i); }
}
