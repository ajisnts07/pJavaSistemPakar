/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.database.DatabaseMySQL;
import com.sikar.model.Aturan;

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
public class AturanDAOMySQL implements AturanDAO {
    @Override
    public void insert(Aturan a) throws SQLException {
        String sql = "INSERT INTO aturan VALUES (?,?,?)";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, a.getKodeAturan());
        ps.setObject(2, a.getJika());
        ps.setObject(3, a.getMaka());
        ps.executeUpdate();
    }

    @Override
    public void update(Aturan a) throws SQLException {
       String sql = "UPDATE aturan SET jika=?, maka=? WHERE kode_aturan=?";
       PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
       ps.setObject(1, a.getJika());
       ps.setObject(2, a.getMaka());
       ps.setString(3, a.getKodeAturan());
       ps.executeUpdate();
    }

    @Override
    public void delete(String kodeAturan) throws SQLException {
        String sql = "DELETE FROM aturan WHERE kode_aturan=?";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, kodeAturan);
        ps.executeUpdate();
    }

    @Override
    public List<Aturan> getAll() throws SQLException {
        Statement st = DatabaseMySQL.connectDB().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM aturan");
        List<Aturan>list = new ArrayList<Aturan>();
        while(rs.next()){
            Aturan a = new Aturan();
            a.setKodeAturan(rs.getString("kode_aturan"));
            a.setJika(rs.getString("jika"));        
            a.setMaka(rs.getString("maka"));
            list.add(a);
        }
        return list;
    }
}
