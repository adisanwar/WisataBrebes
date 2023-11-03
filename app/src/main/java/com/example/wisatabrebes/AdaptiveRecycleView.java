package com.example.wisatabrebes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptiveRecycleView extends RecyclerView.Adapter<AdaptiveRecycleView.ViewHolder> {

    private ArrayList<itemModel> dataItem;
    private OnItemClickListener mListener;

    public AdaptiveRecycleView(ArrayList<itemModel> data, OnItemClickListener listener) {
        dataItem = data;
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textJudul;
        TextView textRating;
        ImageView imgPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textJudul = itemView.findViewById(R.id.textJudul);
            textRating = itemView.findViewById(R.id.rating);
            imgPoster = itemView.findViewById(R.id.image_poster);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(itemModel item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        itemModel currentItem = dataItem.get(position);

        // Bind data to the views
        holder.textJudul.setText(currentItem.getJudul());
        holder.textRating.setText(currentItem.getRating());
        holder.imgPoster.setImageResource(currentItem.getPoster());

        // Set a click listener on the item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }
}

