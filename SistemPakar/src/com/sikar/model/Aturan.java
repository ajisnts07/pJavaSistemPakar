/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.model;

/**
 *
 * @author admin01
 */
public class Aturan {
    private String kode_aturan;
    private String jika;
    private String maka;

    // Setter
    public void setKodeAturan(String kode_aturan) {
        this.kode_aturan = kode_aturan;
    }
    public void setJika(String jika) {
        this.jika = jika;
    }
    public void setMaka(String maka) {
        this.maka = maka;
    }

    // Getter
    public String getKodeAturan() {
        return kode_aturan;
    }
    public String getJika() {
        return jika;
    }
    public String getMaka() {
        return maka;
    }
}
