package com.example.wisatabrebes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder> {
    private ArrayList<itemModel> items = new ArrayList<>();

    public void setItems(ArrayList<itemModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_item, parent, false);
        return new ImageSliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSliderViewHolder holder, int position) {
        itemModel currentItem = items.get(position);
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ImageSliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        ImageSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(itemModel item) {
            // Extract image resource ID from itemModel and set it to ImageView
            imageView.setImageResource(item.getPoster());
        }
    }
}

