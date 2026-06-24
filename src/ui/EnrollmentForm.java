package ui;

import logic.EnrollmentManager;
import model.Enrollment;
import java.util.*;

public class EnrollmentForm extends BaseManagementForm {

    private final EnrollmentManager manager;

    public EnrollmentForm() {
        super(
            "Enrollment Management",
            new String[]{ "Student ID", "Course Code", "Semester" },
            new String[]{ "Student ID", "Course Code", "Semester" }
        );
        this.manager = new EnrollmentManager();
        init();
    }

    @Override
    protected Object buildObject() {
        try {
            return new Enrollment(
                fields[0].getText().trim(),
                fields[1].getText().trim(),
                Integer.parseInt(fields[2].getText().trim())
            );
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Semester must be a whole number.");
            return null;
        }
    }

    @Override
    protected List<Object[]> loadRows() {
        List<Object[]> rows = new ArrayList<>();
        for (Enrollment e : manager.getAll()) rows.add(e.toRow());
        return rows;
    }

    @Override protected void callAdd(Object obj)           { manager.add((Enrollment) obj); }
    @Override protected void callUpdate(int i, Object obj) { manager.update(i, (Enrollment) obj); }
    @Override protected void callDelete(int i)             { manager.delete(i); }
}
