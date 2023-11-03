package com.example.wisatabrebes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_wisata);

        // Ambil informasi yang dikirimkan dari MainActivity
        Intent intent = getIntent();
        String judul = intent.getStringExtra("judul");
        String rating = intent.getStringExtra("rating");
        String deskripsi = intent.getStringExtra("deskripsi");
        int gambarResId = intent.getIntExtra("gambar", 0); // Mengambil ID gambar


        // Tampilkan informasi di dalam Activity Description
        TextView textJudul = findViewById(R.id.destination_title);
        TextView textRating = findViewById(R.id.text_rating);
        TextView textDeskripsi = findViewById(R.id.destination_description);
        ImageView imageView = findViewById(R.id.destination_image); // ImageView untuk menampilkan gambar

        textJudul.setText(judul);
        textRating.setText(rating);
        textDeskripsi.setText(deskripsi);
        imageView.setImageResource(gambarResId); // Menampilkan gambar
    }
}
