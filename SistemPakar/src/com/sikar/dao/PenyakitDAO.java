/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.model.Penyakit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin01
 */
public interface PenyakitDAO {
    public void insert(Penyakit p) throws SQLException;
    public void update(Penyakit p) throws SQLException;
    public void delete(String kodePenyakit) throws SQLException;
    public List<Penyakit> getAll() throws SQLException;
}
