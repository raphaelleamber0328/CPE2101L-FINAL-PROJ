package finalProj;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class HomePageProfile {

    private JFrame frame;
    private JTextField fromField; 
    private JComboBox<String> toBox;
    private JComboBox<String> classBox;
    private JSpinner dateSpinner;
    private JSpinner seatsSpinner;
    private JTextField priceField;
    private JTextField custIdField;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField passportField;
    private JTable flightsTable;
    private DefaultTableModel flightsModel;
    private JTextField selFlightField; 

    private User currentUser; 

    
    private final Map<String, Integer> basePrice = new HashMap<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                User testUser = new User("user@example.com", "pass", "Guest User", 30, "09000000000", "NA", "user@example.com");
                HomePageProfile window = new HomePageProfile(testUser); 
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HomePageProfile(User user) { 
        this.currentUser = user; 

        basePrice.put("Cebu", 3000);
        basePrice.put("Davao", 3500);
        basePrice.put("Iloilo", 2800);
        basePrice.put("Bacolod", 2700);
        basePrice.put("Tacloban", 2500);
        basePrice.put("Bohol", 2600);
        basePrice.put("Zamboanga", 3800);
        basePrice.put("General Santos", 4000);
        basePrice.put("Palawan", 3200);
        basePrice.put("Cagayan de Oro", 3600);

        initialize(user.getEmail());
        updatePrice();
        
        String[] nameParts = user.getFullName().split(" ");
        fnameField.setText(nameParts[0]);
        lnameField.setText(nameParts.length > 1 ? nameParts[1] : "");
        custIdField.setText(user.getEmail().split("@")[0].toUpperCase()); 
    }

    private void initialize(String email) {
        frame = new JFrame();
        frame.setTitle("Home - Flight Booking (PH Domestic)");
        frame.setBounds(100, 40, 1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        Color maroon = new Color(133, 14, 53);
        Font headerFont = new Font("Segoe UI Black", Font.PLAIN, 30);
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 16);

      
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBounds(10, 10, 720, 720);
        leftPanel.setLayout(null);
        frame.getContentPane().add(leftPanel);

        JLabel selectCountry = new JLabel("Search Flights");
        selectCountry.setFont(headerFont);
        selectCountry.setForeground(maroon);
        selectCountry.setBounds(20, 10, 500, 40);
        leftPanel.add(selectCountry);

        JPanel selectionBox = new JPanel();
        selectionBox.setLayout(null);
        selectionBox.setBackground(Color.WHITE);
        selectionBox.setBorder(new LineBorder(maroon, 2, true));
        selectionBox.setBounds(20, 70, 680, 180);
        leftPanel.add(selectionBox);

        JLabel fromLbl = new JLabel("From:");
        fromLbl.setFont(labelFont);
        fromLbl.setForeground(maroon);
        fromLbl.setBounds(20, 18, 120, 25);
        selectionBox.add(fromLbl);

        
        fromField = new JTextField("Cebu");
        fromField.setBounds(20, 48, 200, 32);
        fromField.setFont(labelFont);
        fromField.setBorder(new LineBorder(maroon, 1));
        fromField.setEditable(false);
        selectionBox.add(fromField);

        JLabel toLbl = new JLabel("To:");
        toLbl.setFont(labelFont);
        toLbl.setForeground(maroon);
        toLbl.setBounds(250, 18, 120, 25);
        selectionBox.add(toLbl);

        toBox = new JComboBox<>(new String[]{
                "Manila", "Davao", "Iloilo", "Bacolod", "Tacloban",
                "Bohol", "Zamboanga", "General Santos",
                "Palawan", "Cagayan de Oro"
        });
        toBox.setBounds(250, 48, 200, 32);
        toBox.setFont(labelFont);
        toBox.setBorder(new LineBorder(maroon, 1));
        selectionBox.add(toBox);

        JLabel dateLbl = new JLabel("Travel Date:");
        dateLbl.setFont(labelFont);
        dateLbl.setForeground(maroon);
        dateLbl.setBounds(20, 95, 150, 25);
        selectionBox.add(dateLbl);

        SpinnerDateModel sdm = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(sdm);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setBounds(20, 125, 200, 32);
        dateSpinner.setBorder(new LineBorder(maroon, 1));
        selectionBox.add(dateSpinner);

        JLabel classLbl = new JLabel("Class:");
        classLbl.setFont(labelFont);
        classLbl.setForeground(maroon);
        classLbl.setBounds(250, 95, 150, 25);
        selectionBox.add(classLbl);

        classBox = new JComboBox<>(new String[]{"Economy", "Business"});
        classBox.setBounds(250, 125, 180, 32);
        classBox.setFont(labelFont);
        classBox.setBorder(new LineBorder(maroon, 1));
        selectionBox.add(classBox);

        JButton searchFlightsBtn = new JButton("Search Flights");
        searchFlightsBtn.setBackground(new Color(255, 204, 204));
        searchFlightsBtn.setForeground(maroon);
        searchFlightsBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        searchFlightsBtn.setBounds(470, 85, 180, 50);
        selectionBox.add(searchFlightsBtn);
        
        
        JButton historyBtn = new JButton("View History"); 
        historyBtn.setBackground(new Color(255, 204, 204));
        historyBtn.setForeground(maroon);
        historyBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        historyBtn.setBounds(470, 20, 180, 50); 
        selectionBox.add(historyBtn);
        
        historyBtn.addActionListener(e -> { 
            new BookingHistoryPage(currentUser).setVisible(true); 
        });


       
        flightsModel = new DefaultTableModel(
                new Object[]{"Flight No","Airline","From","To","Date","DepTime","ArrTime","Price"},0
        );
        flightsTable = new JTable(flightsModel);
        flightsTable.setRowHeight(28);

        JScrollPane flightsScroll = new JScrollPane(flightsTable);
        flightsScroll.setBounds(20, 270, 680, 350);
        leftPanel.add(flightsScroll);

        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(740, 10, 440, 720);
        rightPanel.setLayout(null);
        frame.getContentPane().add(rightPanel);

        JLabel header = new JLabel("Customer Details");
        header.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        header.setForeground(maroon);
        header.setBounds(20, 10, 400, 40);
        rightPanel.add(header);

        JLabel custLbl = new JLabel("Customer ID:");
        custLbl.setFont(labelFont);
        custLbl.setForeground(maroon);
        custLbl.setBounds(20, 70, 120, 25);
        rightPanel.add(custLbl);

        custIdField = new JTextField("CS001");
        custIdField.setBounds(150, 70, 200, 28);
        custIdField.setBorder(new LineBorder(maroon, 1));
        rightPanel.add(custIdField);

        JLabel fnLbl = new JLabel("First Name:");
        fnLbl.setFont(labelFont);
        fnLbl.setForeground(maroon);
        fnLbl.setBounds(20, 120, 110, 25);
        rightPanel.add(fnLbl);

        fnameField = new JTextField();
        fnameField.setBounds(150, 120, 250, 28);
        fnameField.setBorder(new LineBorder(maroon, 1));
        rightPanel.add(fnameField);

        JLabel lnLbl = new JLabel("Last Name:");
        lnLbl.setFont(labelFont);
        lnLbl.setForeground(maroon);
        lnLbl.setBounds(20, 160, 110, 25);
        rightPanel.add(lnLbl);

        lnameField = new JTextField();
        lnameField.setBounds(150, 160, 250, 28);
        lnameField.setBorder(new LineBorder(maroon, 1));
        rightPanel.add(lnameField);

        JLabel passLbl = new JLabel("Passport No:");
        passLbl.setFont(labelFont);
        passLbl.setForeground(maroon);
        passLbl.setBounds(20, 200, 110, 25);
        rightPanel.add(passLbl);

        passportField = new JTextField();
        passportField.setBounds(150, 200, 250, 28);
        passportField.setBorder(new LineBorder(maroon, 1));
        rightPanel.add(passportField);

        JLabel priceLbl = new JLabel("Total Price:");
        priceLbl.setFont(labelFont);
        priceLbl.setForeground(maroon);
        priceLbl.setBounds(20, 260, 120, 25);
        rightPanel.add(priceLbl);

        priceField = new JTextField();
        priceField.setBounds(150, 260, 150, 32);
        priceField.setEditable(false);
        priceField.setBorder(new LineBorder(maroon, 1));
        rightPanel.add(priceField);

        JLabel seatsLbl = new JLabel("Seats:");
        seatsLbl.setFont(labelFont);
        seatsLbl.setForeground(maroon);
        seatsLbl.setBounds(20, 310, 120, 25);
        rightPanel.add(seatsLbl);

        seatsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        seatsSpinner.setBounds(150, 310, 80, 32);
        seatsSpinner.setBorder(new LineBorder(maroon, 1));
        rightPanel.add(seatsSpinner);

        selFlightField = new JTextField(); 
        selFlightField.setBounds(150, 360, 250, 28);
        selFlightField.setBorder(new LineBorder(maroon, 1));
        selFlightField.setEditable(false);
        rightPanel.add(selFlightField);

        JLabel selFlightLbl = new JLabel("Selected Flight:");
        selFlightLbl.setFont(labelFont);
        selFlightLbl.setForeground(maroon);
        selFlightLbl.setBounds(20, 360, 120, 25);
        rightPanel.add(selFlightLbl);

        JButton confirmBtn = new JButton("Confirm Booking");
        confirmBtn.setBackground(new Color(255, 204, 204));
        confirmBtn.setForeground(maroon);
        confirmBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        confirmBtn.setBounds(40, 420, 360, 40);
        rightPanel.add(confirmBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(new Color(220, 220, 220));
        cancelBtn.setForeground(maroon);
        cancelBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cancelBtn.setBounds(40, 480, 360, 40);
        rightPanel.add(cancelBtn);

        
        searchFlightsBtn.addActionListener(e -> {
            String from = fromField.getText();
            String to = (String) toBox.getSelectedItem();
            String date = formatDate((Date) dateSpinner.getValue());

            if (from.equals(to)) {
                JOptionPane.showMessageDialog(frame, "FROM and TO cannot be the same.");
                return;
            }

            flightsModel.setRowCount(0);

            
            flightsModel.addRow(new Object[]{"PH1001", "Philippine Airlines", from, to, date, "06:00 AM", "07:30 AM", basePrice.getOrDefault(to, 2500)});
            flightsModel.addRow(new Object[]{"CEB2022", "Cebu Pacific", from, to, date, "08:00 AM", "09:30 AM", (int)(basePrice.getOrDefault(to, 2500)*1.05)});
            flightsModel.addRow(new Object[]{"APX3007", "AirAsia", from, to, date, "09:00 AM", "10:30 AM", (int)(basePrice.getOrDefault(to, 2500)*0.95)});
            flightsModel.addRow(new Object[]{"PH1010", "Philippine Airlines", from, to, date, "11:00 AM", "12:30 PM", (int)(basePrice.getOrDefault(to, 2500)*1.1)});
            flightsModel.addRow(new Object[]{"CEB2040", "Cebu Pacific", from, to, date, "02:00 PM", "03:30 PM", (int)(basePrice.getOrDefault(to, 2500)*1.15)});
            flightsModel.addRow(new Object[]{"APX3050", "AirAsia", from, to, date, "06:00 PM", "07:30 PM", (int)(basePrice.getOrDefault(to, 2500)*0.9)});
            flightsModel.addRow(new Object[]{"PH1020", "Philippine Airlines", from, to, date, "08:00 PM", "09:30 PM", (int)(basePrice.getOrDefault(to, 2500)*1.2)});
        });

        flightsTable.getSelectionModel().addListSelectionListener(ev -> {
            int sel = flightsTable.getSelectedRow();
            if (sel >= 0) {
                String flightNo = flightsModel.getValueAt(sel, 0).toString();
                String flightName = flightsModel.getValueAt(sel, 1).toString();
                selFlightField.setText(flightNo + " - " + flightName);
                updatePrice();
            }
        });

        toBox.addActionListener(e -> updatePrice());
        classBox.addActionListener(e -> updatePrice());
        seatsSpinner.addChangeListener(e -> updatePrice());

        confirmBtn.addActionListener(e -> {
            int sel = flightsTable.getSelectedRow();
            if (sel < 0) {
                JOptionPane.showMessageDialog(frame, "Please select a flight.");
                return;
            }

            String fname = fnameField.getText().trim();
            String lname = lnameField.getText().trim();
            String passport = passportField.getText().trim();

            if (fname.isEmpty() || lname.isEmpty() || passport.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fill out all customer details.");
                return;
            }
            
            String toCity = (String) toBox.getSelectedItem();
            String flightDetails = selFlightField.getText();
            Date travelDate = (Date) dateSpinner.getValue();
            
            Booking newBooking = new Booking(currentUser, toCity, flightDetails, travelDate); 
            currentUser.addBooking(newBooking); 

            JOptionPane.showMessageDialog(frame, "Booking confirmed! ID: " + newBooking.getBookingID()); 
            clearFields();
        });

        cancelBtn.addActionListener(e -> clearFields());
    }

    private String formatDate(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(d);
    }

    private void updatePrice() {
        String to = (String) toBox.getSelectedItem();
        String cls = (String) classBox.getSelectedItem();
        int seats = (int) seatsSpinner.getValue();

        int base = basePrice.getOrDefault(to, 2500);
        double multi = cls.equals("Business") ? 1.6 : 1.0;
        int total = (int) Math.round(base * multi * seats);

        priceField.setText(String.valueOf(total));
    }

    private void clearFields() {
        custIdField.setText("");
        fnameField.setText("");
        lnameField.setText("");
        passportField.setText("");
        priceField.setText("");
        seatsSpinner.setValue(1);
        toBox.setSelectedIndex(0);
        classBox.setSelectedIndex(0);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}