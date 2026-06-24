package ui;

import logic.GradeManager;
import model.Grade;
import java.util.*;

public class GradeForm extends BaseManagementForm {

    private final GradeManager manager;

    public GradeForm() {
        super(
            "Grade Management",
            new String[]{ "Student ID", "Course Code", "Assignment", "Midterm", "Final Exam" },
            new String[]{ "Student ID", "Course Code", "Assignment", "Midterm", "Final Exam",
                          "Total", "Letter Grade" }
        );
        this.manager = new GradeManager();
        init();
    }

    @Override
    protected Object buildObject() {
        try {
            return new Grade(
                fields[0].getText().trim(),
                fields[1].getText().trim(),
                Double.parseDouble(fields[2].getText().trim()),
                Double.parseDouble(fields[3].getText().trim()),
                Double.parseDouble(fields[4].getText().trim())
            );
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Assignment, Midterm and Final Exam must be numbers.");
            return null;
        }
    }

    @Override
    protected List<Object[]> loadRows() {
        List<Object[]> rows = new ArrayList<>();
        for (Grade g : manager.getAll()) rows.add(g.toRow());
        return rows;
    }

    @Override protected void callAdd(Object obj)           { manager.add((Grade) obj); }
    @Override protected void callUpdate(int i, Object obj) { manager.update(i, (Grade) obj); }
    @Override protected void callDelete(int i)             { manager.delete(i); }
}
