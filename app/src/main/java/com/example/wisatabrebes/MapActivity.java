package com.example.wisatabrebes;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MapActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peta_lokasi);

        // Inisialisasi Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Atur judul pada Toolbar
        getSupportActionBar().setTitle("Peta Lokasi");

        webView = findViewById(R.id.webView);

        // Inisialisasi pengaturan WebView
        WebSettings webSettings = webView.getSettings();

        // Aktifkan JavaScript (jika diperlukan)
        webSettings.setJavaScriptEnabled(true);

        // Atur WebViewClient untuk menangani permintaan di dalam WebView (buka URL dalam WebView, bukan peramban eksternal)
        webView.setWebViewClient(new WebViewClient());

        // Memuat halaman web tertentu

        String lokasi = getIntent().getStringExtra("judul");
        String url = "https://www.google.com/maps/search/"+lokasi;
        webView.loadUrl(url);
    }
}

