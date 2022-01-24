/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sikar.model;

/**
 *
 * @author admin01
 */
public class Penyakit {
    private String kode_penyakit;
    private String nama_penyakit;
    private String deskripsi_penyakit;
    private String solusi;

    // Setter
    public void setKodePenyakit(String kode_penyakit) {
        this.kode_penyakit = kode_penyakit;
    }
    public void setNamaPenyakit(String nama_penyakit) {
        this.nama_penyakit = nama_penyakit;
    }
    public void setDeskripsiPenyakit (String deskripsi_penyakit) {
        this.deskripsi_penyakit = deskripsi_penyakit;
    }
    public void setSolusi (String solusi) {
        this.solusi = solusi;
    }

    // Getter
    public String getNamaPenyakit() {
        return nama_penyakit;
    }
    public String getKodePenyakit() {
        return kode_penyakit;
    }
    public String getDeskripsiPenyakit() {
        return deskripsi_penyakit;
    }
    public String getSolusi() {
        return solusi;
    }
}
