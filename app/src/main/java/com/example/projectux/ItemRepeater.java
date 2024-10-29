package com.example.projectux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemRepeater extends RecyclerView.Adapter<ItemRepeater.ItemHolder> {
    private List<Data> mDataset;
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(Data item);
    }
    public static class ItemHolder extends RecyclerView.ViewHolder{
        private TextView itemName,itemPrice,itemRating,itemSold;
        private ImageView itemImage;
        public Data data;
        public ItemHolder(View v, OnItemClickListener listener, List<Data> mDataset){
            super(v);
            itemImage = v.findViewById(R.id.item_image);
            itemName = v.findViewById(R.id.item_name);
            itemPrice = v.findViewById(R.id.item_price);
            itemRating = v.findViewById(R.id.item_rating);
            itemSold = v.findViewById(R.id.item_sold);
            v.setOnClickListener(e ->{
                int position = getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION && listener != null){
                    listener.onItemClick(mDataset.get(position));
                }
            });
        }
    }
    public ItemRepeater(List<Data> data, OnItemClickListener listener){
        this.mDataset = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repeater,parent,false);
        return new ItemHolder(v,listener,mDataset);
    }
    @Override
    public void onBindViewHolder(ItemHolder holder, int position){
        Data currItem = mDataset.get(position);
        holder.itemImage.setImageResource(currItem.imgSource);
        holder.itemName.setText(currItem.name);
        String conPrice = "Rp."+currItem.price;
        holder.itemPrice.setText(conPrice);
        String conRating = String.format("%.1f",currItem.rating);
        holder.itemRating.setText(conRating);
        String conSold = " | "+currItem.sold+"k+ sold";
        holder.itemSold.setText(conSold);
    }
    @Override
    public int getItemCount(){
        return mDataset.size();
    }
}
