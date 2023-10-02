/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateTimeCheckerForm {
    private JFrame frame;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;

    public DateTimeCheckerForm() {
        frame = new JFrame("Date Time Checker"); // Set the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Increase the width
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout for the entire frame

        // Load the logo image from file
        ImageIcon logoIcon = new ImageIcon("D:\\00. User\\Documents\\NetBeansProjects\\JavaApplication1\\src\\images\\logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        // Create a label for the logo
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setPreferredSize(new Dimension(200, 50)); // Set the size to 50x100
        logoLabel.setMinimumSize(new Dimension(200, 50));

        // Create GridBagConstraints for logo label
        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.gridx = 0; // Start in the first column
        logoConstraints.gridy = 0; // Start in the first row
        logoConstraints.gridwidth = 2; // Span one column
        logoConstraints.fill = GridBagConstraints.CENTER; // Center the logo label
        logoConstraints.insets = new Insets(10, 10, 10, 10); // Add padding

        frame.add(logoLabel, logoConstraints); // Add the logo label to the frame

        // Set a custom font and color for the title
        Font titleFont = new Font("Arial", Font.BOLD, 26); // Make the title bold
        Color titleColor = Color.BLUE; // Set the title color to blue
        JLabel titleLabel = new JLabel("Date Time Checker");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(titleColor); // Set the title color

        // Create GridBagConstraints for title label
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0; // Start in the first column
        titleConstraints.gridy = 1; // Start in the second row
        titleConstraints.gridwidth = 2; // Span two columns
        titleConstraints.fill = GridBagConstraints.CENTER; // Center the title label
        titleConstraints.insets = new Insets(10, 10, 10, 10); // Add padding

        frame.add(titleLabel, titleConstraints); // Add the title label to the frame

        // Create and add input fields and buttons here, adjusting grid constraints as needed
        createInputFieldsAndButtons();

        frame.setVisible(true);
    }

    private void createInputFieldsAndButtons() {
        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel dayLabel = new JLabel("Day:");
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 2; // Start in the third row
        frame.add(dayLabel, inputConstraints);

        dayField = new JTextField(10);
        inputConstraints.gridx = 1;
        frame.add(dayField, inputConstraints);

        JLabel monthLabel = new JLabel("Month:");
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 3; // Start in the fourth row
        frame.add(monthLabel, inputConstraints);

        monthField = new JTextField(10);
        inputConstraints.gridx = 1;
        frame.add(monthField, inputConstraints);

        JLabel yearLabel = new JLabel("Year:");
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 4; // Start in the fifth row
        frame.add(yearLabel, inputConstraints);

        yearField = new JTextField(10);
        inputConstraints.gridx = 1;
        frame.add(yearField, inputConstraints);

        JButton checkButton = new JButton("Check");
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 5; // Start in the sixth row
        frame.add(checkButton, inputConstraints);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDateTime();
            }
        });

        JButton clearButton = new JButton("Clear");
        inputConstraints.gridx = 1;
        frame.add(clearButton, inputConstraints);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DateTimeCheckerForm();
            }
        });
    }

     public void checkDateTime() {
        int dayInput, monthInput, yearInput;

        try {
            dayInput = Integer.parseInt(dayField.getText());
            monthInput = Integer.parseInt(monthField.getText());
            yearInput = Integer.parseInt(yearField.getText());
        } catch (NumberFormatException e) {
            showMessage("Input data for Day, Month, or Year is not a number!");
            return;
        }

        if (dayInput < 1 || dayInput > 31) {
            showMessage("Input data for Day is out of range!");
            return;
        }

        if (monthInput < 1 || monthInput > 12) {
            showMessage("Input data for Month is out of range!");
            return;
        }

        if (yearInput < 1000 || yearInput > 3000) {
            showMessage("Input data for Year is out of range!");
            return;
        }

        if (isValidDate(yearInput, monthInput, dayInput)) {
            showMessage(dayInput + "/" + monthInput + "/" + yearInput + " is a correct date time!");
        } else {
            showMessage(dayInput + "/" + monthInput + "/" + yearInput + " is NOT a correct date time!");
        }
    }

    public void clearFields() {
        dayField.setText("");
        monthField.setText("");
        yearField.setText("");
    }

    public int daysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1; // Invalid month
        }
    }

    public boolean isValidDate(int year, int month, int day) {
        if (month >= 1 && month <= 12) {
            if (day >= 1 && day <= daysInMonth(year, month)) {
                return true;
            }
        }
        return false;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}
