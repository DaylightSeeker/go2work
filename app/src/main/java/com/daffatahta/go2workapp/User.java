package com.daffatahta.go2workapp;

public class User {
    public String username, email, password, tanggal , provinsi ,kota, tipe, namaPerusahaan, websitePerusahaan, contact;


    public User(String username, String email, String password, String tanggal, String kota, String provinsi, String tipe) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.kota = kota;
        this.provinsi = provinsi;
        this.tanggal = tanggal;
        this.tipe = "user";

    }

    public User(String username, String email, String password, String namaPerusahaan, String kota, String websitePerusahaan, String contact,String tipe){
        this.username = username;
        this.email = email;
        this.password = password;
        this.namaPerusahaan = namaPerusahaan;
        this.kota = kota;
        this.websitePerusahaan = websitePerusahaan;
        this.tipe = "company";
        this.contact = contact;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getWebsitePerusahaan() {
        return websitePerusahaan;
    }

    public void setWebsitePerusahaan(String websitePerusahaan) {
        this.websitePerusahaan = websitePerusahaan;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
