/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

/**
 *
 * @author shivr
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConnectDatabase {
       static Connection connection=null;
    public static Connection ConnectToDB() {
        try {
             connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/HexadBookLibrary","root","Raghvan@1998");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
      }

 }
