package finalProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LoginAndSignUp {

    private JFrame frame;
    private JTextField usernameField; 
    private JPasswordField passwordField; 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginAndSignUp window = new LoginAndSignUp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginAndSignUp() {
        initialize();
    }

    private void initialize() {

        
        frame = new JFrame();
        frame.setTitle("LOGIN");
        frame.setBounds(250, 150, 900, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(133, 14, 53));
        leftPanel.setBounds(0, 0, 450, 500);
        leftPanel.setLayout(null);
        frame.getContentPane().add(leftPanel);

        JLabel planeIcon = new JLabel();
        planeIcon.setBounds(36, 58, 373, 354);
        planeIcon.setHorizontalAlignment(SwingConstants.CENTER);
        planeIcon.setIcon(new ImageIcon("C:\\Users\\Amber Lerio\\Downloads\\logo1!.png"));
        leftPanel.add(planeIcon);

        // RIGHT PANEL
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(450, 0, 450, 500);
        rightPanel.setLayout(null);
        frame.getContentPane().add(rightPanel);

        JLabel loginLabel = new JLabel("LOG IN");
        loginLabel.setForeground(new Color(133, 14, 53));
        loginLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        loginLabel.setBounds(150, 40, 200, 50);
        rightPanel.add(loginLabel);

        JLabel usernameLbl = new JLabel("Email");
        usernameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        usernameLbl.setForeground(new Color(133, 14, 53));
        usernameLbl.setBounds(70, 130, 150, 25);
        rightPanel.add(usernameLbl);

        usernameField = new JTextField(); // <--- FIELD ASSIGNMENT
        usernameField.setBounds(70, 160, 300, 35);
        usernameField.setBorder(new LineBorder(new Color(133, 14, 53), 1));
        rightPanel.add(usernameField);

        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordLbl.setForeground(new Color(133, 14, 53));
        passwordLbl.setBounds(70, 210, 150, 25);
        rightPanel.add(passwordLbl);

        passwordField = new JPasswordField(); // <--- FIELD ASSIGNMENT
        passwordField.setBounds(70, 240, 300, 35);
        passwordField.setBorder(new LineBorder(new Color(133, 14, 53), 1));
        rightPanel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(255, 204, 204));
        loginBtn.setForeground(new Color(133, 14, 53));
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginBtn.setBounds(160, 300, 120, 35);
        rightPanel.add(loginBtn);

        JLabel signUpText = new JLabel("Don't have an account?");
        signUpText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        signUpText.setBounds(150, 350, 200, 25);
        rightPanel.add(signUpText);

        JButton createBtn = new JButton("Create Account");
        createBtn.setBackground(new Color(255, 204, 204));
        createBtn.setForeground(new Color(133, 14, 53));
        createBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        createBtn.setBounds(150, 380, 150, 35);
        rightPanel.add(createBtn);

       
        createBtn.addActionListener(e -> {
            CreateAccount signupWindow = new CreateAccount();
            signupWindow.setVisible(true);
            frame.dispose();
        });

       
        loginBtn.addActionListener(e -> {
            String email = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword());

            if (email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(frame, "Invalid email format.");
                return;
            }

                        User loggedInUser = UserDatabase.getInstance().authenticateUser(email, pass); 
            if (loggedInUser != null) {
                JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + loggedInUser.getFullName());
                
      
                new HomePage(loggedInUser).setVisible(true); 
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email or password.");
            }
        });
    }
}