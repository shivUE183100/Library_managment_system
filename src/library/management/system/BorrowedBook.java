/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author shivr
 */
public class BorrowedBook extends javax.swing.JFrame {

    /**
     * Creates new form BookIssued
     */
    public BorrowedBook() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    public void clear(){
        bookIdField.setText("");
        userIdField.setText("");
        //borrowDateField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookIdField = new javax.swing.JTextField();
        userIdField = new javax.swing.JTextField();
        borrowButton = new javax.swing.JButton();
        closeButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Borrow Book..");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 240, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Book ID");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 158, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User ID");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 158, 40));

        bookIdField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(bookIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 273, 40));

        userIdField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(userIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 273, 40));

        borrowButton.setBackground(new java.awt.Color(153, 0, 51));
        borrowButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        borrowButton.setForeground(new java.awt.Color(255, 255, 255));
        borrowButton.setText("Borrow ");
        borrowButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        borrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButtonActionPerformed(evt);
            }
        });
        getContentPane().add(borrowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, 84, 26));

        closeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-27.png"))); // NOI18N
        closeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 31, 31));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registImage.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1112, 766));

        setBounds(420, 0, 1112, 766);
    }// </editor-fold>//GEN-END:initComponents

    private void borrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButtonActionPerformed
        // TODO add your handling code here:
        
          if (bookIdField.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(rootPane, "Please enter Book ID");
        bookIdField.requestFocus();
    } else if (userIdField.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(rootPane, "Please enter User ID");
        userIdField.requestFocus();
    } else {
        int userId = Integer.parseInt(userIdField.getText().trim());
        int bookId = Integer.parseInt(bookIdField.getText().trim());

        String checkBookCount = "SELECT total_copies FROM Books WHERE book_id = ?";
        String borrowBookQuery = "INSERT INTO BorrowedBooks (user_id, book_id) VALUES (?, ?)";
        String updateBookCount = "UPDATE Books SET total_copies = total_copies - 1 WHERE book_id = ?";
        String checkBorrowLimit = "SELECT COUNT(*) AS borrow_count FROM BorrowedBooks WHERE user_id = ? AND returned_at IS NULL";
        String deleteBookQuery = "DELETE FROM Books WHERE book_id = ?";

        try (Connection connection = ConnectDatabase.ConnectToDB();
             PreparedStatement checkBorrowLimitSt = connection.prepareStatement(checkBorrowLimit);
             PreparedStatement checkBookCountSt = connection.prepareStatement(checkBookCount)) {

            // Check user's borrowing limit
            checkBorrowLimitSt.setInt(1, userId);
            ResultSet borrowLimitResult = checkBorrowLimitSt.executeQuery();
            if (borrowLimitResult.next() && borrowLimitResult.getInt("borrow_count") >= 2) {
                JOptionPane.showMessageDialog(null, "Borrow limit reached! Return a book to borrow a new one.");
                return;
            }
            
            // Check if the book is available
            checkBookCountSt.setInt(1, bookId);
            ResultSet bookCountResult = checkBookCountSt.executeQuery();

            if (bookCountResult.next()) {
                int totalCopies = bookCountResult.getInt("total_copies");

                if (totalCopies > 0) {
                    // Borrow the book
                    try (PreparedStatement borrowBookSt = connection.prepareStatement(borrowBookQuery);
                         PreparedStatement updateBookCountSt = connection.prepareStatement(updateBookCount)) {

                        borrowBookSt.setInt(1, userId);
                        borrowBookSt.setInt(2, bookId);
                        borrowBookSt.executeUpdate(); // Add to BorrowedBooks

                        updateBookCountSt.setInt(1, bookId);
                        updateBookCountSt.executeUpdate(); // Update book count

                        JOptionPane.showMessageDialog(null, "Book borrowed successfully!");

                        if (totalCopies - 1 == 0) {
                            try (PreparedStatement deleteBookSt = connection.prepareStatement(deleteBookQuery)) {
                                deleteBookSt.setInt(1, bookId);
                                deleteBookSt.executeUpdate(); // Delete book if count reaches 0
                                JOptionPane.showMessageDialog(null, "Book count reached 0. Book removed from the library.");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No copies available for this book.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Book not found in the library.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowedBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    }//GEN-LAST:event_borrowButtonActionPerformed

    private void closeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BorrowedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowedBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookIdField;
    private javax.swing.JButton borrowButton;
    private javax.swing.JButton closeButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField userIdField;
    // End of variables declaration//GEN-END:variables
}
