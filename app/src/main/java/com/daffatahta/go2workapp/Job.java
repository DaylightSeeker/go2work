package com.daffatahta.go2workapp;

public class Job {
    public String nama, jenis, lokasi, gaji, fasilitas, waktu;

    public Job(String nama, String jenis, String lokasi, String gaji, String fasilitas, String waktu){
        this.nama = nama;
        this.jenis= jenis;
        this.lokasi = lokasi;
        this.gaji = gaji;
        this.fasilitas = fasilitas;
        this.waktu = waktu;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public Job() {
    }
}
