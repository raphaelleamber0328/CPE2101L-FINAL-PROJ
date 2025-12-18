package guiProj;

import guiProj.User;
import guiProj.Booking;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookingHistoryPage {

    private JFrame frame;
    private JTable historyTable;
    private DefaultTableModel tableModel;
    private User currentUser;
    
    private final Color maroon = new Color(133, 14, 53); 
    private final Color paleMaroon = new Color(255, 204, 204);  
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public BookingHistoryPage(User user) {
        this.currentUser = user;
        initialize();
        loadBookingData();
    }

    private void initialize() {
        frame = new JFrame("Transaction History");
        frame.setBounds(100, 100, 800, 560); 
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        JLabel title = new JLabel("Your Booking History");
        title.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        title.setForeground(maroon);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        frame.getContentPane().add(title, BorderLayout.NORTH);

        String[] columnNames = {"Booking ID", "Destination", "Flight Details", "Date Booked", "Travel Date", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        historyTable = new JTable(tableModel);
        historyTable.setRowHeight(25);
        historyTable.getTableHeader().setBackground(paleMaroon); 
        historyTable.getTableHeader().setForeground(maroon);

        JScrollPane scrollPane = new JScrollPane(historyTable);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); 
        buttonPanel.setBackground(paleMaroon); 
        
        JButton cancelButton = new JButton("Cancel Selected Booking");
        
        cancelButton.setBackground(paleMaroon); 
        cancelButton.setForeground(maroon);
        
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        cancelButton.addActionListener(e -> handleCancellation());
        
        buttonPanel.add(cancelButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH); 
    }
    
    private void loadBookingData() {
        tableModel.setRowCount(0); 
        for (Booking booking : currentUser.getBookingHistory()) {
            tableModel.addRow(new Object[]{
                booking.getBookingID(),
                booking.getDestinationCity(), 
                booking.getFlightDetails(),
                dateFormat.format(booking.getDateBooked()), 
                dateFormat.format(booking.getTravelDate()),
                booking.getStatus() + " (" + booking.getBookingType() + ")"
            });
        }
    }
    
    private void handleCancellation() {
        int selectedRow = historyTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a booking to cancel.");
            return;
        }

        String bookingID = (String) tableModel.getValueAt(selectedRow, 0);

        for (Booking booking : currentUser.getBookingHistory()) {
            if (booking.getBookingID().equals(bookingID)) {
                
                if (booking.getStatus().equals(Booking.CANCELED)) {
                    JOptionPane.showMessageDialog(frame, "Error: This booking is already canceled.", "Cancellation Failed", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to cancel booking ID: " + bookingID + "?", 
                    "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (booking.cancelBooking()) {
                        JOptionPane.showMessageDialog(frame, "Booking " + bookingID + " successfully CANCELED.");
                        loadBookingData();
                    } else {
                        JOptionPane.showMessageDialog(frame, 
                            "Cancellation failed: The travel date must be in the future (Upcoming booking) to be canceled.", 
                            "Cancellation Failed", JOptionPane.WARNING_MESSAGE);
                    }
                }
                return;
            }
        }
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}