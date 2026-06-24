package model;

public class Instructor {
    private String id;
    private String name;
    private String email;
    private String department;
    private String specialization;

    public Instructor(String id, String name, String email, String department, String specialization) {
        this.id             = id;
        this.name           = name;
        this.email          = email;
        this.department     = department;
        this.specialization = specialization;
    }

    // Deserialize a pipe-delimited line back into an Instructor object
    public static Instructor fromString(String line) {
        String[] p = line.split("\\|");
        return new Instructor(p[0], p[1], p[2], p[3], p[4]);
    }

    public String getId()             { return id; }
    public String getName()           { return name; }
    public String getEmail()          { return email; }
    public String getDepartment()     { return department; }
    public String getSpecialization() { return specialization; }

    // Returns the values as a display-ready Object[] for the JTable row
    public Object[] toRow() {
        return new Object[]{ id, name, email, department, specialization };
    }

    @Override
    public String toString() {
        return String.join("|", id, name, email, department, specialization);
    }
}
