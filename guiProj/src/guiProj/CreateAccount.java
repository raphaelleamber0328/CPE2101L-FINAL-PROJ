package guiProj;

import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import javax.swing.*;
import finalProjectBooking.User;
import finalProjectBooking.UserDatabase;

public class CreateAccount {

    private JFrame frame;
    private JTextField firstNameField, lastNameField, ageField, contactNumberField, emailField;
    private JPasswordField passField, confirmPassField;
    
    private final Color maroon = new Color(133, 14, 53);

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CreateAccount window = new CreateAccount();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CreateAccount() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setTitle("Create Account");
        frame.setBounds(100, 100, 782, 500); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

       
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(maroon);
        leftPanel.setBounds(0, 0, 311, 500); 
        leftPanel.setLayout(null);
        frame.getContentPane().add(leftPanel);

        JLabel planeIcon = new JLabel();
        planeIcon.setBounds(0, 100, 311, 300);
        planeIcon.setHorizontalAlignment(SwingConstants.CENTER);
        planeIcon.setIcon(new ImageIcon("C:\\Users\\Amber Lerio\\Downloads\\logo1!.png"));
        leftPanel.add(planeIcon);

        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(310, 0, 472, 463); 
        rightPanel.setLayout(null);
        frame.getContentPane().add(rightPanel);

        JLabel title = new JLabel("CREATE ACCOUNT");
        title.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        title.setForeground(maroon);
        title.setBounds(112, 10, 350, 50);
        rightPanel.add(title);

        Font lblFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel fnLbl = new JLabel("First Name:");
        fnLbl.setFont(lblFont);
        fnLbl.setBounds(60, 51, 200, 20);
        rightPanel.add(fnLbl);

        firstNameField = new JTextField();
        firstNameField.setFont(fieldFont);
        firstNameField.setBounds(60, 70, 150, 28);
        rightPanel.add(firstNameField);

        JLabel lnLbl = new JLabel("Last Name:");
        lnLbl.setFont(lblFont);
        lnLbl.setBounds(240, 51, 200, 20);
        rightPanel.add(lnLbl);

        lastNameField = new JTextField();
        lastNameField.setFont(fieldFont);
        lastNameField.setBounds(240, 70, 150, 28);
        rightPanel.add(lastNameField);

       
        JLabel ageLbl = new JLabel("Age:");
        ageLbl.setFont(lblFont);
        ageLbl.setBounds(60, 108, 200, 28);
        rightPanel.add(ageLbl);

        ageField = new JTextField();
        ageField.setFont(fieldFont);
        ageField.setBounds(60, 137, 330, 28);
        rightPanel.add(ageField);

        
        JLabel contactLbl = new JLabel("Contact Number:");
        contactLbl.setFont(lblFont);
        contactLbl.setBounds(60, 175, 200, 20);
        rightPanel.add(contactLbl);

        contactNumberField = new JTextField();
        contactNumberField.setFont(fieldFont);
        contactNumberField.setBounds(60, 200, 330, 28);
        rightPanel.add(contactNumberField);

      
        JLabel emailLbl = new JLabel("Email:");
        emailLbl.setFont(lblFont);
        emailLbl.setBounds(60, 238, 200, 20);
        rightPanel.add(emailLbl);

        emailField = new JTextField();
        emailField.setFont(fieldFont);
        emailField.setBounds(60, 263, 330, 28);
        rightPanel.add(emailField);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setFont(lblFont);
        passLbl.setBounds(60, 295, 200, 20);
        rightPanel.add(passLbl);

        passField = new JPasswordField();
        passField.setFont(fieldFont);
        passField.setBounds(60, 318, 330, 28);
        rightPanel.add(passField);

        JLabel confirmLbl = new JLabel("Confirm Password:");
        confirmLbl.setFont(lblFont);
        confirmLbl.setBounds(60, 355, 200, 20);
        rightPanel.add(confirmLbl);

        confirmPassField = new JPasswordField();
        confirmPassField.setFont(fieldFont);
        confirmPassField.setBounds(60, 378, 330, 28);
        rightPanel.add(confirmPassField);

        
        JButton createBtn = new JButton("Create Account");
        createBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        createBtn.setForeground(maroon); 
        createBtn.setBackground(Color.WHITE); 
        createBtn.setBounds(138, 424, 170, 30);
        rightPanel.add(createBtn);

       
        createBtn.addActionListener(e -> {

            String fname = firstNameField.getText().trim();
            String lname = lastNameField.getText().trim();
            String ageText = ageField.getText().trim();
            String contact = contactNumberField.getText().trim();
            String email = emailField.getText().trim();
            String pass = new String(passField.getPassword());
            String confirm = new String(confirmPassField.getPassword());

            if (fname.isEmpty() || lname.isEmpty() || ageText.isEmpty() ||
                contact.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {

                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(frame, "Invalid email format.");
                return;
            }

            
            if (!contact.matches("^09\\d{9}$")) {
                JOptionPane.showMessageDialog(frame, "Contact must start with 09 and be 11 digits.");
                return;
            }

            
            int age;
            try {
                age = Integer.parseInt(ageText);
                if (age < 18) {
                    JOptionPane.showMessageDialog(frame, "You must be at least 18.");
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Age must be a number.");
                return;
            }

            
            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!");
                return;
            }

            String username = email;
            String fullName = fname + " " + lname;
            String address = "N/A";
            String contactNum = contact;
            
            if (UserDatabase.getInstance().findUserByEmail(email) != null) {
                JOptionPane.showMessageDialog(frame, "Account already exists with this email.");
                return;
            }

            User newUser = new User(username, pass, fullName, age, contactNum, address, email);
            UserDatabase.getInstance().addUser(newUser);

            JOptionPane.showMessageDialog(frame, "Account Created Successfully!");

            frame.dispose();
            new HomePageProfile(newUser).setVisible(true);
        });
    }

    public void setVisible(boolean value) {
        frame.setVisible(value);
    }
}