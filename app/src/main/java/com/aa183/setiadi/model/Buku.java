package com.aa183.setiadi.model;

import com.google.gson.annotations.SerializedName;

public class Buku {

    @SerializedName("id") private int id;
    @SerializedName("judul") private String judul;
    @SerializedName("gambar") private String gambar;
    @SerializedName("jenis") private String jenis;
    @SerializedName("halaman") private String halaman;
    @SerializedName("bahasa") private String bahasa;
    @SerializedName("penulis") private String penulis;
    @SerializedName("tahun") private String tahun;

    public Buku(int id, String judul, String gambar, String jenis, String halaman, String bahasa, String penulis, String tahun) {
        this.id = id;
        this.judul = judul;
        this.gambar = gambar;
        this.jenis = jenis;
        this.halaman = halaman;
        this.bahasa = bahasa;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHalaman() {
        return halaman;
    }

    public void setHalaman(String halaman) {
        this.halaman = halaman;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
