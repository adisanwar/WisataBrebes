package com.example.wisatabrebes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
//import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptiveRecycleView.OnItemClickListener {
    RecyclerView recyclerView;
    AdaptiveRecycleView adaptiveRecycleView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<itemModel> data;

    ViewPager2 imageSlider;
    ImageSliderAdapter imageSliderAdapter;
    Handler sliderHandler = new Handler();
    private int currentPage = 0;
    private static final long SLIDE_DELAY = 5000;
    Button showMapOnClick;
    private SearchView searchView;
    private ArrayList<itemModel> originalData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        originalData = new ArrayList<>();
        data = new ArrayList<>();
        for (int i = 0; i < myItem.judul.length; i++) {
            itemModel item = new itemModel(
                    myItem.judul[i],
                    myItem.rating[i],
                    myItem.poster[i],
                    myItem.deskripsi[i]
            );

            data.add(item);
            originalData.add(item);
        }

        adaptiveRecycleView = new AdaptiveRecycleView(data, this); // Pass the listener
        recyclerView.setAdapter(adaptiveRecycleView);

        imageSlider = findViewById(R.id.imageSlider);
        imageSliderAdapter = new ImageSliderAdapter();
        imageSlider.setAdapter(imageSliderAdapter);
        imageSlider.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Inisialisasi ViewPager2
        imageSliderAdapter.setItems(data);

        // Set auto slide
        startSlider();

        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
        });

        // Initialize the SearchView
        searchView = findViewById(R.id.search);
//        searchView.setQueryHint("Search");

        // Set up a QueryTextListener to handle search queries
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle search query text change in real-time
                performSearch(newText);
                if (newText.isEmpty()) {
                    imageSlider.setVisibility(View.VISIBLE);
                } else {
                    imageSlider.setVisibility(View.GONE);
                }
                return true;
            }

        });


    }
    private void performSearch(String query) {
        // Use the filterData method in your RecyclerView adapter to filter data based on the search query
        adaptiveRecycleView.filterData(query);
    }



    private void startSlider() {
        Runnable slideRunnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= imageSliderAdapter.getItemCount()) {
                    currentPage = 0;
                }
                imageSlider.setCurrentItem(currentPage);
                currentPage++;
                sliderHandler.postDelayed(this, SLIDE_DELAY);
            }
        };

        sliderHandler.postDelayed(slideRunnable, SLIDE_DELAY);
    }



    @Override
    public void onItemClick(itemModel item) {
        // Ketika item diklik, buat intent untuk menampilkan deskripsi
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("judul", item.getJudul());
        intent.putExtra("rating", item.getRating());
        intent.putExtra("gambar", item.getPoster());
        intent.putExtra("deskripsi", item.getDeskripsi());

        startActivity(intent);
    }


}
