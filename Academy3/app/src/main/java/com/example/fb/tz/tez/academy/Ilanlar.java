package com.example.fb.tz.tez.academy;

import java.io.Serializable;

public class Ilanlar implements Serializable {
    private int ilan_id;
    private String ilan_foto;
    private String ilan_baslik;
    private String ilan_alt_baslik;
    private String ilan_icerik;
    private Kategoriler kategori;

    public Ilanlar() {
    }

    public Ilanlar(int ilan_id, String ilan_foto, String ilan_baslik, String ilan_alt_baslik, String ilan_icerik, Kategoriler kategori) {
        this.ilan_id = ilan_id;
        this.ilan_foto = ilan_foto;
        this.ilan_baslik = ilan_baslik;
        this.ilan_alt_baslik = ilan_alt_baslik;
        this.ilan_icerik = ilan_icerik;
        this.kategori = kategori;
    }

    public int getIlan_id() {
        return ilan_id;
    }

    public void setIlan_id(int ilan_id) {
        this.ilan_id = ilan_id;
    }

    public String getIlan_foto() {
        return ilan_foto;
    }

    public void setIlan_foto(String ilan_foto) {
        this.ilan_foto = ilan_foto;
    }

    public String getIlan_baslik() {
        return ilan_baslik;
    }

    public void setIlan_baslik(String ilan_baslik) {
        this.ilan_baslik = ilan_baslik;
    }

    public String getIlan_alt_baslik() {
        return ilan_alt_baslik;
    }

    public void setIlan_alt_baslik(String ilan_alt_baslik) {
        this.ilan_alt_baslik = ilan_alt_baslik;
    }

    public String getIlan_icerik() {
        return ilan_icerik;
    }

    public void setIlan_icerik(String ilan_icerik) {
        this.ilan_icerik = ilan_icerik;
    }

    public Kategoriler getKategori() {
        return kategori;
    }

    public void setKategori(Kategoriler kategori) {
        this.kategori = kategori;
    }
}
