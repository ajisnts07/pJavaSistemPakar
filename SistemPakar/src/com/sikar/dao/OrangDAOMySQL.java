/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.database.DatabaseMySQL;
import com.sikar.model.Orang;

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
public class OrangDAOMySQL implements OrangDAO {
    @Override
    public void insert(Orang o) throws SQLException {
        String sql = "INSERT INTO orang VALUES (?,?,?,?,?)";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, o.getId());
        ps.setString(2, o.getNama());
        ps.setString(3, o.getUsername());
        ps.setString(4, o.getPassword());
        ps.setString(5, o.getLevel());
        ps.executeUpdate();
    }

    @Override
    public void update(Orang o) throws SQLException {
       String sql = "UPDATE orang SET nama=?, username=?, password=?, level=? WHERE id=?";
       PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
       ps.setString(1, o.getNama());
       ps.setString(2, o.getUsername());
       ps.setString(3, o.getPassword());
       ps.setString(4, o.getLevel());
       ps.setString(5, o.getId());
       ps.executeUpdate();
    }

    @Override
    public void delete(String idUser) throws SQLException {
        String sql = "DELETE FROM orang WHERE id=?";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, idUser);
        ps.executeUpdate();
    }
    
    @Override
    public Orang loadByUsername(String namaUser) throws SQLException {
        String sql = "SELECT * FROM orang WHERE username = ?";
        PreparedStatement ps = DatabaseMySQL.connectDB().prepareStatement(sql);
        ps.setString(1, namaUser);
        ResultSet rs = ps.executeQuery();
        Orang o = new Orang();
        if(rs.next()){
            o.setId(rs.getString("id"));
            o.setNama(rs.getString("nama"));
            o.setUsername(rs.getString("username"));
            o.setPassword(rs.getString("password"));
            o.setLevel(rs.getString("level"));
        }
        return o;
    }

    @Override
    public List<Orang> getAll() throws SQLException {
        Statement st = DatabaseMySQL.connectDB().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM orang");
        List<Orang>list = new ArrayList<Orang>();
        while(rs.next()){
            Orang o = new Orang();
            o.setId(rs.getString("id"));
            o.setNama(rs.getString("nama"));        
            o.setUsername(rs.getString("username"));
            o.setPassword(rs.getString("password"));
            o.setLevel(rs.getString("level"));
            list.add(o);
        }
        return list;
    }
 }

