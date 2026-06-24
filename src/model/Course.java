package model;

public class Course {
    private String code;
    private String title;
    private int    creditHours;
    private String department;
    private String instructor;

    public Course(String code, String title, int creditHours, String department, String instructor) {
        this.code        = code;
        this.title       = title;
        this.creditHours = creditHours;
        this.department  = department;
        this.instructor  = instructor;
    }

    // Deserialize a pipe-delimited line back into a Course object
    public static Course fromString(String line) {
        String[] p = line.split("\\|");
        return new Course(p[0], p[1], Integer.parseInt(p[2]), p[3], p[4]);
    }

    public String getCode()       { return code; }
    public String getTitle()      { return title; }
    public int    getCreditHours(){ return creditHours; }
    public String getDepartment() { return department; }
    public String getInstructor() { return instructor; }

    // Returns the values as a display-ready Object[] for the JTable row
    public Object[] toRow() {
        return new Object[]{ code, title, creditHours, department, instructor };
    }

    @Override
    public String toString() {
        return String.join("|", code, title, String.valueOf(creditHours), department, instructor);
    }
}
