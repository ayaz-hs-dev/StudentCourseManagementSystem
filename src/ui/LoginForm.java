package ui;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    public LoginForm() {
        setTitle("Login");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        
        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");

        add(new JLabel("Username"));
        add(user);
        add(new JLabel("Password"));
        add(pass);
        add(new JLabel());
        add(login);

        login.addActionListener(e -> {
            if (user.getText().equals("admin")
                    && String.valueOf(pass.getPassword()).equals("1234")) {
                dispose();
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });

        setVisible(true);
    }
}