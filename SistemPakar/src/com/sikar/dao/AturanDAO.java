/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.dao;

import com.sikar.model.Aturan;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin01
 */
public interface AturanDAO {
    public void insert(Aturan a) throws SQLException;
    public void update(Aturan a) throws SQLException;
    public void delete(String kodeAturan) throws SQLException;
    public List<Aturan> getAll() throws SQLException;
}
