/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.database.DatabaseMySQL;
import com.sikar.model.Gejala;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
/**
 *
 * @author admin01
 */
public class GejalaDAOMySQL implements GejalaDAO {
    @Override
    public void insert(Gejala g) throws SQLException {
        String sql = "INSERT INTO gejala VALUES (?,?,?)";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, g.getKodeGejala());
        ps.setString(2, g.getNamaGejala());
        ps.setString(3, g.getPertanyaan());
        ps.executeUpdate();
    }

    @Override
    public void update(Gejala g) throws SQLException {
       String sql = "UPDATE gejala SET nama_gejala=?, pertanyaan=? WHERE kode_gejala=?";
       PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
       ps.setString(1, g.getNamaGejala());
       ps.setString(2, g.getPertanyaan());
       ps.setString(3, g.getKodeGejala());
       ps.executeUpdate();
    }

    @Override
    public void delete(String kodeGejala) throws SQLException {
        String sql = "DELETE FROM gejala WHERE kode_gejala=?";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, kodeGejala);
        ps.executeUpdate();
    }

    @Override
    public List<Gejala> getAll() throws SQLException {
        Statement st = DatabaseMySQL.connectDB().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM gejala");
        List<Gejala>list = new ArrayList<Gejala>();
        while(rs.next()){
            Gejala g = new Gejala();
            g.setKodeGejala(rs.getString("kode_gejala"));
            g.setNamaGejala(rs.getString("nama_gejala"));        
            g.setPertanyaan(rs.getString("pertanyaan"));
            list.add(g);
        }
        return list;
    }
}
