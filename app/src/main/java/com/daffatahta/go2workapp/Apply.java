package com.daffatahta.go2workapp;

public class Apply {
    public String nama;
    public String namaPekerjaan;
    public String idCompany;
    public String emailUser;
    public String hpUser;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getHpUser() {
        return hpUser;
    }

    public void setHpUser(String hpUser) {
        this.hpUser = hpUser;
    }

    public Apply() {
    }

    public Apply(String nama, String namaPekerjaan, String idCompany, String emailUser, String hpUser) {
        this.nama = nama;
        this.namaPekerjaan = namaPekerjaan;
        this.idCompany = idCompany;
        this.emailUser = emailUser;
        this.hpUser = hpUser;
    }
}
