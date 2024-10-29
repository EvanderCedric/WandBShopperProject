package com.example.projectux;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class NavBarTop extends LinearLayout {

    public NavBarTop(Context context){
        super(context);
        init(context);
    }

    public NavBarTop(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.navigatio_top_bar, this, true);

        ImageButton button1 = findViewById(R.id.logout_button);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LoginPage.class);
            getContext().startActivity(intent);
        });

    }
}
