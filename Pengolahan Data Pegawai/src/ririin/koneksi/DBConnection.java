/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ririin.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class DBConnection {
    private Connection koneksi;
    //untuk koneksi ke driver mysql
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil load Drivernya");
// untuk mengetahui kalau driver berhasil doload
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("gagal load Drivernya " + ex);
        }
        //untuk koneksi database
        try {
        String url = "jdbc:mysql://localhost:3306/data_pegawai";//nama database yang akan dibuat
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Konek ke database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Konek ke database");
            JOptionPane.showMessageDialog(null, "Gagal Koneksi","Peringatan",
                    JOptionPane.WARNING_MESSAGE);
        }
            return koneksi;
    }
}
