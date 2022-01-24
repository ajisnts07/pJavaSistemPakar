/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.model;

/**
 *
 * @author admin01
 */
public class Orang {
    private String id;
    private String nama;
    private String username;
    private String password;
    private String level;

    // Setter
    public void setId(String id) {
        this.id = id;
    } 
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    // Getter
    public String getId(){
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getLevel() {
        return level;
    }
}
