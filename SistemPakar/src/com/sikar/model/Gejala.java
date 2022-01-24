/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.model;

/**
 *
 * @author admin01
 */
public class Gejala {
    private String kode_gejala;
    private String nama_gejala;
    private String pertanyaan;

    // Setter
    public void setKodeGejala(String kode_gejala) {
        this.kode_gejala = kode_gejala;
    }
    public void setNamaGejala(String nama_gejala) {
        this.nama_gejala = nama_gejala;
    }
    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    // Getter
    public String getKodeGejala() {
        return kode_gejala;
    }
    public String getNamaGejala() {
        return nama_gejala;
    }
    public String getPertanyaan() {
        return pertanyaan;
    }
}
