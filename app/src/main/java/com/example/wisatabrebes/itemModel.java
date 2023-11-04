package com.example.wisatabrebes;

public class itemModel {
    String judul, rating;
    int poster;
    private String deskripsi;


    public itemModel(String judul, String rating, int poster, String deskripsi) {
        this.judul = judul;
        this.rating = rating;
        this.poster = poster;
        this.deskripsi = deskripsi;


    }

    public String getJudul() {
        return judul;
    }

    public String getRating() {
        return rating;
    }

    public int getPoster() {
        return poster;
    }
    public String getDeskripsi() {
        return deskripsi;
    }

}
