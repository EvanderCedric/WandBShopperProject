package com.example.projectux;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OutfitDetails extends AppCompatActivity {

    private Button submitBtn;
    private EditText emailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_outfit_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView prodImage = findViewById(R.id.item_page_image);
        TextView prodNameTxt = findViewById(R.id.item_page_name);
        TextView prodPriceTxt = findViewById(R.id.item_page_price);
        TextView prodDescTxt = findViewById(R.id.item_page_desc);

        Intent intent = getIntent();
        String name = intent.getStringExtra("prodName");
        int imageSource = intent.getIntExtra("prodImg", 0);
        String price = intent.getStringExtra("prodPrice");
        String desc = intent.getStringExtra("prodDesc");

        prodImage.setImageResource(imageSource);
        prodNameTxt.setText("Name : " + name);
        prodPriceTxt.setText("Price : Rp." + price);
        prodDescTxt.setText("Description : " + desc);

        TextView itemBack = findViewById(R.id.item_page_back);
        itemBack.setOnClickListener(e -> finish());

        // Initialize the submit button and email text field
        submitBtn = findViewById(R.id.submitBtn);
        emailTxt = findViewById(R.id.emailField);

        submitBtn.setOnClickListener(v -> {
            String email = emailTxt.getText().toString().trim();
            if (!TextUtils.isEmpty(email) && email.contains("@gmail.com")) {
                Toast.makeText(OutfitDetails.this, "Thank you for submitting", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(() -> {
                    Intent backIntent = new Intent(OutfitDetails.this, ItemPage.class);
                    startActivity(backIntent);
                }, 2500);
            } else {
                Toast.makeText(OutfitDetails.this, "Email must contain @gmail.com", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
