package com.example.projectux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ImagePageAdapter extends RecyclerView.Adapter<ImagePageAdapter.CarouselViewHolder> {
    private List<DataCaro> dataCaroList;
    public ImagePageAdapter(List<DataCaro> dataCaroList){
        this.dataCaroList = dataCaroList;
    }
    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_all, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        DataCaro data = dataCaroList.get(position);
        holder.imageView.setImageResource(data.imgId);
        holder.prevBtn.setOnClickListener(v -> {

            int nextImg = (position-1) % dataCaroList.size();
            if(nextImg == -1){
                nextImg = dataCaroList.size()-1;
            }
            int nextImgSrc = dataCaroList.get(nextImg).imgId;
            holder.imageView.setImageResource(nextImgSrc);
        });
        holder.nextBtn.setOnClickListener(v -> {
            int nextImg = (position+1) % dataCaroList.size();
            int nextImgSrc = dataCaroList.get(nextImg).imgId;
            holder.imageView.setImageResource(nextImgSrc);
        });
    }

    @Override
    public int getItemCount() {
        return dataCaroList.size();
    }
    public static class CarouselViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView prevBtn,nextBtn;
        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.CarImg);
            prevBtn = itemView.findViewById(R.id.prevCarImg);
            nextBtn = itemView.findViewById(R.id.nextCarImg);
        }
    }
}
