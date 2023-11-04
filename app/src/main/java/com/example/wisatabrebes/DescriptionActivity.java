package com.example.wisatabrebes;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    Button showMapOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_wisata);

        Intent intent = getIntent();
        String judul = intent.getStringExtra("judul");
        String rating = intent.getStringExtra("rating");
        String deskripsi = intent.getStringExtra("deskripsi");
        int gambarResId = intent.getIntExtra("gambar", 0);


        TextView textJudul = findViewById(R.id.destination_title);
        TextView textRating = findViewById(R.id.text_rating);
        TextView textDeskripsi = findViewById(R.id.destination_description);
        ImageView imageView = findViewById(R.id.destination_image);
        showMapOnClick = findViewById(R.id.show_map_button);

        textJudul.setText(judul);
        textRating.setText(rating);
        textDeskripsi.setText(deskripsi);
        imageView.setImageResource(gambarResId);

    }

//    public void onShowMapClick(View view) {
//        String lokasi = getIntent().getStringExtra("judul"); // Get the location title from the intent
//
//
//        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        startActivity(mapIntent);
//    }

    public void onShowMapClick(View view) {
        String lokasi = getIntent().getStringExtra("judul"); // Get the location title from the intent

        // Create an intent to open the MapActivity
        Intent mapIntent = new Intent(this, MapActivity.class);

        // Pass the location title as an extra to the MapActivity
        mapIntent.putExtra("judul", lokasi);

        // Start the MapActivity
        startActivity(mapIntent);
    }

}
