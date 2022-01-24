/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.model.Orang;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin01
 */
public interface OrangDAO {
    public void insert(Orang o) throws SQLException;
    public void update(Orang o) throws SQLException;
    public void delete(String idUser) throws SQLException;
    public Orang loadByUsername(String namaUser) throws SQLException;
    public List<Orang> getAll() throws SQLException;
}
