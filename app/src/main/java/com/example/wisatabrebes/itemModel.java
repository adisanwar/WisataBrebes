package com.example.wisatabrebes;

public class itemModel {
    String judul, rating;
    int poster;
    private String deskripsi;
    double latitude, longitude;

    public itemModel(String judul, String rating, int poster, String deskripsi, double latitude, double longitude) {
        this.judul = judul;
        this.rating = rating;
        this.poster = poster;
        this.deskripsi = deskripsi;
        this.latitude = latitude;
        this.longitude = longitude;

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
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


}
