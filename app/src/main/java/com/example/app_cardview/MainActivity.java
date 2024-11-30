package com.example.app_cardview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare the CardViews
    private CardView D1, D2, D3, D4, D5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Setting the layout file for the activity

        // Initialize CardViews by finding them by their ID
        D1 = findViewById(R.id.card_view);
        D2 = findViewById(R.id.d2);
        D3 = findViewById(R.id.d3);
        D4 = findViewById(R.id.d4);
        D5 = findViewById(R.id.d5);

        // Set onClickListeners to handle CardView clicks
        D1.setOnClickListener(this);
        D2.setOnClickListener(this);
        D3.setOnClickListener(this);
        D4.setOnClickListener(this);
        D5.setOnClickListener(this);

        // Initialize and set OnClickListener for the specific "App Bar" card view
        CardView cardView = findViewById(R.id.card_view);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AppBarActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onClick(View v) {
        Intent i = null;

        // Use if-else statements to check the clicked view ID
        if (v.getId() == R.id.card_view) {
            i = new Intent(this, d1.class);
        } else if (v.getId() == R.id.d2) {
            i = new Intent(this, d2.class);
        } else if (v.getId() == R.id.d3) {
            i = new Intent(this, d3.class);
        } else if (v.getId() == R.id.d4) {
            i = new Intent(this, d4.class);
        } else if (v.getId() == R.id.d5) {
            i = new Intent(this, d5.class);
        }

        // If the Intent was initialized, start the activity
        if (i != null) {
            startActivity(i);
        }
    }
}
