package model;

public class Enrollment {
    private String studentId;
    private String courseCode;
    private int    semester;

    public Enrollment(String studentId, String courseCode, int semester) {
        this.studentId  = studentId;
        this.courseCode = courseCode;
        this.semester   = semester;
    }

    // Deserialize a pipe-delimited line back into an Enrollment object
    public static Enrollment fromString(String line) {
        String[] p = line.split("\\|");
        return new Enrollment(p[0], p[1], Integer.parseInt(p[2]));
    }

    public String getStudentId()  { return studentId; }
    public String getCourseCode() { return courseCode; }
    public int    getSemester()   { return semester; }

    // Returns the values as a display-ready Object[] for the JTable row
    public Object[] toRow() {
        return new Object[]{ studentId, courseCode, semester };
    }

    @Override
    public String toString() {
        return studentId + "|" + courseCode + "|" + semester;
    }
}
