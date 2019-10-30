package com.daffatahta.go2workapp;

public class User {
    public String username, email, password, tanggal , provinsi ,kota, tipe;

    public User(String username, String email, String password, String tanggal, String kota, String provinsi, String tipe) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.kota = kota;
        this.provinsi = provinsi;
        this.tanggal = tanggal;
        this.tipe = "user";

    }

    public User(){

    }
}
