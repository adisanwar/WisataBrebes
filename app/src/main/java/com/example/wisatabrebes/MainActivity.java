package com.example.wisatabrebes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptiveRecycleView.OnItemClickListener {
    RecyclerView recyclerView;
    AdaptiveRecycleView adaptiveRecycleView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<itemModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i = 0; i < myItem.judul.length; i++) {
            data.add(new itemModel(
                    myItem.judul[i],
                    myItem.rating[i],
                    myItem.poster[i],
                    myItem.deskripsi[i],


            ));
        }

        adaptiveRecycleView = new AdaptiveRecycleView(data, this); // Pass the listener
        recyclerView.setAdapter(adaptiveRecycleView);
    }

    @Override
    public void onItemClick(itemModel item) {
        // Ketika item diklik, buat intent untuk menampilkan deskripsi
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("judul", item.getJudul());
        intent.putExtra("rating", item.getRating());
        intent.putExtra("gambar", item.getPoster());
        intent.putExtra("deskripsi", item.getDeskripsi()); // Kirim deskripsi
        // Anda dapat menambahkan informasi tambahan yang diperlukan ke intent di sini

        startActivity(intent);
    }
}
