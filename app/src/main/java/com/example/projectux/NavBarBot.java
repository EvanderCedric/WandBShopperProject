package com.example.projectux;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class NavBarBot extends LinearLayout {

    public NavBarBot(Context context) {
        super(context);
        init(context);
    }

    public NavBarBot(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NavBarBot(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.navigation_bottom_bar, this, true);

        ImageButton home = findViewById(R.id.nav_home);
        ImageButton item = findViewById(R.id.nav_product);
        ImageButton info = findViewById(R.id.nav_info);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), HomePage.class);
            getContext().startActivity(intent);
        });

        item.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ItemPage.class);
            getContext().startActivity(intent);
        });

        info.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AboutPage.class);
            getContext().startActivity(intent);
        });
    }
}
