package com.example.projectux;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {
    ArrayList<Data> dataList = new ArrayList<>();
    ArrayList<DataCaro> caroImg = new ArrayList<>();
    private LayoutInflater inflater;
    private FrameLayout itemDetailsSubpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outfit_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dataList.add(new Data("Holo Shirt Size M","350.000",4.7f,"50",R.drawable.niceshirt));
        dataList.add(new Data("Hawt Jeans Size L","545.000",4.5f,"31",R.drawable.hawtjeans));
        dataList.add(new Data("Kool Hat","350.000",3.9f,"8",R.drawable.chillhat));
        dataList.add(new Data("Iridescent Dress","215.000",4.6f,"6",R.drawable.kooldress));
        dataList.add(new Data("Sport Tank Top","350.000",4.7f,"50",R.drawable.tanktop));
        dataList.add(new Data("Wedding Dress","350.000",4.7f,"50",R.drawable.weddress));
        dataList.add(new Data("Wedding Dress","350.000",4.7f,"50",R.drawable.redshorts));
        dataList.add(new Data("Monarch Bag","350.000",4.7f,"50",R.drawable.butterflybag));
        dataList.add(new Data("Nikey Shoes","350.000",4.7f,"50",R.drawable.nikeshoes));
        dataList.add(new Data("Hiky Heels","350.000",4.7f,"50",R.drawable.genheels));


        caroImg.add(new DataCaro(R.drawable.kooldress));
        caroImg.add(new DataCaro(R.drawable.chillhat));
        caroImg.add(new DataCaro(R.drawable.butterflybag));
        caroImg.add(new DataCaro(R.drawable.tanktop));
        caroImg.add(new DataCaro(R.drawable.nikeshoes));


        inflater = LayoutInflater.from(this);
        itemDetailsSubpage = findViewById(R.id.outfit_details_subpage);

        Button bs = findViewById(R.id.best_seller_btn);
        Button ao = findViewById(R.id.all_outfit_btn);
        View initV = inflater.inflate(R.layout.all_outfit,itemDetailsSubpage,false);
        replaceContent(initV);
        setupCarouselView(initV);
        setupRecyclerView(initV);

        bs.setOnClickListener(v->{
            View bestSellerPage = inflater.inflate(R.layout.all_outfit, itemDetailsSubpage, false);
            replaceContent(bestSellerPage);
            new Handler().postDelayed(()->{
                setupCarouselView(bestSellerPage);
                setupRecyclerView(bestSellerPage);
            },300);

            bs.setBackgroundResource(R.color.outfit_focused);
            ao.setBackgroundResource(R.color.outfit_notfocused);
        });

        ao.setOnClickListener(v->{
            View allOutfitPage = inflater.inflate(R.layout.best_seller, itemDetailsSubpage, false);
            replaceContent(allOutfitPage);
            new Handler().postDelayed(()->{
                setupRecyclerView(allOutfitPage);
            },300);
            ao.setBackgroundResource(R.color.outfit_focused);
            bs.setBackgroundResource(R.color.outfit_notfocused);
        });
    }
    private void replaceContent(View newContent){
        itemDetailsSubpage.removeAllViews();
        itemDetailsSubpage.addView(newContent);
    }
    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.best_seller_list); // Adjust based on the layout being inflated
        ItemRepeater adapter = new ItemRepeater(dataList, item -> {
            // Handle item click
            Intent intent = new Intent(ItemPage.this, OutfitDetails.class);
            intent.putExtra("prodImg", item.imgSource);
            intent.putExtra("prodName", item.name);
            intent.putExtra("prodPrice", item.price);
            intent.putExtra("prodDesc", "This product has a rating of " + item.rating + " and has been bought more than " + item.sold + " times");
            startActivity(intent);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    private void setupCarouselView(View view){
        ViewPager2 caroCont = view.findViewById(R.id.viewpager_all);
        if(caroCont != null){
            ImagePageAdapter adapter = new ImagePageAdapter(caroImg);
            caroCont.setAdapter(adapter);
            Handler sliderHandler = new Handler(Looper.getMainLooper());
            Runnable sliderRunnable = new Runnable() {
                @Override
                public void run() {
                    int currentItem = caroCont.getCurrentItem();
                    int nextItem = (currentItem + 1) % caroImg.size();
                    caroCont.setCurrentItem(nextItem);
                    sliderHandler.postDelayed(this, 5000); // Change slide every 5 seconds
                }
            };
            sliderHandler.postDelayed(sliderRunnable, 5000);

        }

    }
}