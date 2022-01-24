/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author admin01
 */
public class DatabaseMySQL {
    Connection DatabaseMySQL = null;
    public static Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/javasikar", "root", "");
            return koneksi;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
