package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    private JTextField numPasswordsField;
    private JTextField passwordLengthField;
    private JTextArea passwordsArea;

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.add(new JLabel("Number of passwords:"));
        numPasswordsField = new JTextField();
        inputPanel.add(numPasswordsField);
        inputPanel.add(new JLabel("Password length:"));
        passwordLengthField = new JTextField();
        inputPanel.add(passwordLengthField);

        JButton generateButton = new JButton("Generate Passwords");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePasswords();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);

        passwordsArea = new JTextArea();
        passwordsArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(passwordsArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void generatePasswords() {
        try {
            int numPw = Integer.parseInt(numPasswordsField.getText());
            int numPwLength = Integer.parseInt(passwordLengthField.getText());

            String[] randomPasswords = new String[numPw];

            for (int i = 0; i < numPw; i++) {
                StringBuilder randomPasswordBuilder = new StringBuilder();
                for (int j = 0; j < numPwLength; j++) {
                    randomPasswordBuilder.append(randomCharacter());
                }
                randomPasswords[i] = randomPasswordBuilder.toString();
            }

            StringBuilder passwordsText = new StringBuilder();
            for (String password : randomPasswords) {
                passwordsText.append(password).append("\n");
            }

            passwordsArea.setText(passwordsText.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for number of passwords and password length.");
        }
    }

    private char randomCharacter() {
        int rand = (int) (Math.random() * 62);

        if (rand <= 9) {
            return (char) (rand + 48); // '0'-'9' => 48-57 IN ASCII
        } else if (rand <= 35) {
            return (char) (rand - 10 + 65); // 'A'-'Z' => 65-90 IN ASCII
        } else {
            return (char) (rand - 36 + 97); // 'a'-'z' => 97-122 IN ASCII
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGeneratorGUI().setVisible(true);
            }
        });
    }
}
