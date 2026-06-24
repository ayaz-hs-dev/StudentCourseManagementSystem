package model;

public class Grade {
    private String studentId;
    private String courseCode;
    private double assignment;
    private double midterm;
    private double finalExam;

    public Grade(String studentId, String courseCode, double assignment, double midterm, double finalExam) {
        this.studentId  = studentId;
        this.courseCode = courseCode;
        this.assignment = assignment;
        this.midterm    = midterm;
        this.finalExam  = finalExam;
    }

    // Deserialize a pipe-delimited line back into a Grade object
    public static Grade fromString(String line) {
        String[] p = line.split("\\|");
        return new Grade(p[0], p[1],
                Double.parseDouble(p[2]),
                Double.parseDouble(p[3]),
                Double.parseDouble(p[4]));
    }

    public String getStudentId()  { return studentId; }
    public String getCourseCode() { return courseCode; }
    public double getAssignment() { return assignment; }
    public double getMidterm()    { return midterm; }
    public double getFinalExam()  { return finalExam; }

    public double getTotal() { return assignment + midterm + finalExam; }

    public String getLetterGrade() {
        double t = getTotal();
        if (t >= 85) return "A";
        if (t >= 75) return "B";
        if (t >= 65) return "C";
        if (t >= 50) return "D";
        return "F";
    }

    public double getGradePoints() {
        switch (getLetterGrade()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default:  return 0.0;
        }
    }

    // Returns the values as a display-ready Object[] for the JTable row
    // Includes computed Total and Letter Grade columns for the UI
    public Object[] toRow() {
        return new Object[]{ studentId, courseCode, assignment, midterm, finalExam,
                             getTotal(), getLetterGrade() };
    }

    @Override
    public String toString() {
        return String.join("|", studentId, courseCode,
                String.valueOf(assignment),
                String.valueOf(midterm),
                String.valueOf(finalExam));
    }
}
