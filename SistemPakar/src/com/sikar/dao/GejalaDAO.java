/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.model.Gejala;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author admin01
 */
public interface GejalaDAO {
    public void insert(Gejala g) throws SQLException;
    public void update(Gejala g) throws SQLException;
    public void delete(String kodeGejala) throws SQLException;
    public List<Gejala> getAll() throws SQLException;
}
