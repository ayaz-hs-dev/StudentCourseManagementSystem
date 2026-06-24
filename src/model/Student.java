package model;

public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private int semester;

    public Student(String id, String name, String email, String phone, String department, int semester) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.semester = semester;
    }

    // Deserialize a pipe-delimited line back into a Student object
    public static Student fromString(String line) {
        String[] p = line.split("\\|");
        return new Student(p[0], p[1], p[2], p[3], p[4], Integer.parseInt(p[5]));
    }

    public String getId()         { return id; }
    public String getName()       { return name; }
    public String getEmail()      { return email; }
    public String getPhone()      { return phone; }
    public String getDepartment() { return department; }
    public int    getSemester()   { return semester; }

    // Returns the values as a display-ready Object[] for the JTable row
    public Object[] toRow() {
        return new Object[]{ id, name, email, phone, department, semester };
    }

    @Override
    public String toString() {
        return String.join("|", id, name, email, phone, department, String.valueOf(semester));
    }
}
