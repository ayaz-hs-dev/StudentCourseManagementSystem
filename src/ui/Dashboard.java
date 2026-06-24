package ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 5, 5));

        JButton b1 = new JButton("Student Management");
        JButton b2 = new JButton("Course Management");
        JButton b3 = new JButton("Instructor Management");
        JButton b4 = new JButton("Enrollment Management");
        JButton b5 = new JButton("Grade Management");
        JButton b6 = new JButton("Exit");

        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);

        add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);

        b1.addActionListener(e -> new StudentForm());
        b2.addActionListener(e -> new CourseForm());
        b3.addActionListener(e -> new InstructorForm());
        b4.addActionListener(e -> new EnrollmentForm());
        b5.addActionListener(e -> new GradeForm());
        b6.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
