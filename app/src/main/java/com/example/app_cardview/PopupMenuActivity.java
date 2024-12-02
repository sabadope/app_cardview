package com.example.app_cardview;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class PopupMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        // Find the back arrow ImageView
        ImageView backArrow = findViewById(R.id.back_arrow);

        // Set a click listener for the back arrow
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                onBackPressed(); // Or any custom back navigation
            }
        });

        // Find the Button
        Button buttonPopupMenu = findViewById(R.id.buttonPopupMenu);

        // Set a click listener for the button
        buttonPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the popup menu
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View anchor) {
        // Create a PopupMenu
        PopupMenu popupMenu = new PopupMenu(PopupMenuActivity.this, anchor);

        // Inflate the menu resource
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Set a click listener for menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_forward) {
                    Toast.makeText(PopupMenuActivity.this, "Forward clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.menu_reply) {
                    Toast.makeText(PopupMenuActivity.this, "Reply clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });

        // Show the popup menu
        popupMenu.show();
    }
}
