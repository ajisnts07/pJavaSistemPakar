/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.database.DatabaseMySQL;
import com.sikar.model.Penyakit;

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
public class PenyakitDAOMySQL implements PenyakitDAO {
    @Override
    public void insert(Penyakit p) throws SQLException {
        String sql = "INSERT INTO penyakit VALUES (?,?,?,?)";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, p.getKodePenyakit());
        ps.setString(2, p.getNamaPenyakit());
        ps.setString(3, p.getDeskripsiPenyakit());
        ps.setString(4, p.getSolusi());
        ps.executeUpdate();
    }

    @Override
    public void update(Penyakit p) throws SQLException {
        String sql = "UPDATE penyakit SET nama_penyakit=?, deskripsi_penyakit=?, solusi=? WHERE kode_penyakit=?";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, p.getNamaPenyakit());
        ps.setString(2, p.getDeskripsiPenyakit());
        ps.setString(3, p.getSolusi());
        ps.setString(4, p.getKodePenyakit());
        ps.executeUpdate();
    }

    @Override
    public void delete(String kodePenyakit) throws SQLException {
        String sql = "DELETE FROM penyakit WHERE kode_penyakit=?";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, kodePenyakit);
        ps.executeUpdate();
    }

    @Override
    public List<Penyakit> getAll() throws SQLException {
        Statement st = DatabaseMySQL.connectDB().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM penyakit");
        List<Penyakit>list = new ArrayList<Penyakit>();
        while(rs.next()) {
            Penyakit p = new Penyakit();
            p.setKodePenyakit(rs.getString("kode_penyakit"));
            p.setNamaPenyakit(rs.getString("nama_penyakit"));
            p.setDeskripsiPenyakit(rs.getString("deskripsi_penyakit"));
            p.setSolusi(rs.getString("solusi"));
            list.add(p);
        }
        return list;
    }

}
