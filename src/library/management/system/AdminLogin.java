/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library.management.system;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivr
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form UserLogin
     */
    public AdminLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JButton();
        userIdTag = new javax.swing.JLabel();
        passwordTag = new javax.swing.JLabel();
        userIdField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        titleLogin = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1550, 830));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 766));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-27.png"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 0, 40, 40));

        userIdTag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userIdTag.setForeground(new java.awt.Color(255, 255, 255));
        userIdTag.setText("User Id :");
        getContentPane().add(userIdTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 70, 26));

        passwordTag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordTag.setForeground(new java.awt.Color(255, 255, 255));
        passwordTag.setText("Password :");
        getContentPane().add(passwordTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 80, 26));
        getContentPane().add(userIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 190, 30));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 190, 30));

        titleLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLogin.setForeground(new java.awt.Color(255, 255, 255));
        titleLogin.setText("Admin Login to Library");
        getContentPane().add(titleLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 230, -1));

        loginButton.setBackground(new java.awt.Color(153, 0, 0));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginBack.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1540, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        int yes=JOptionPane.showConfirmDialog(this, "Are you want to Close this application?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_closeActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = ConnectDatabase.ConnectToDB();
        try {
             preparedStatement=connection.prepareStatement("SELECT * FROM HexadBookLibrary.login where userId =? AND password=?");
            preparedStatement.setString(1,userIdField.getText());
            preparedStatement.setString(2, passwordField.getText());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
               new LibrarySystem().setVisible(true);
            }              
            else {
                JOptionPane.showMessageDialog(this, "Please Enter Valied ID and Password");
            }       
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTag;
    private javax.swing.JLabel titleLogin;
    private javax.swing.JTextField userIdField;
    private javax.swing.JLabel userIdTag;
    // End of variables declaration//GEN-END:variables
}
