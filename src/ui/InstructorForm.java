package ui;

import logic.InstructorManager;
import model.Instructor;
import java.util.*;

public class InstructorForm extends BaseManagementForm {

    private final InstructorManager manager;

    public InstructorForm() {
        super(
            "Instructor Management",
            new String[]{ "Instructor ID", "Name", "Email", "Department", "Specialization" },
            new String[]{ "Instructor ID", "Name", "Email", "Department", "Specialization" }
        );
        this.manager = new InstructorManager();
        init();
    }

    @Override
    protected Object buildObject() {
        return new Instructor(
            fields[0].getText().trim(),
            fields[1].getText().trim(),
            fields[2].getText().trim(),
            fields[3].getText().trim(),
            fields[4].getText().trim()
        );
    }

    @Override
    protected List<Object[]> loadRows() {
        List<Object[]> rows = new ArrayList<>();
        for (Instructor ins : manager.getAll()) rows.add(ins.toRow());
        return rows;
    }

    @Override protected void callAdd(Object obj)           { manager.add((Instructor) obj); }
    @Override protected void callUpdate(int i, Object obj) { manager.update(i, (Instructor) obj); }
    @Override protected void callDelete(int i)             { manager.delete(i); }
}
