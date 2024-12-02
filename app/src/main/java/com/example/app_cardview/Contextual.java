package com.example.app_cardview;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Contextual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual);

        // Register the view for the context menu
        View someView = findViewById(R.id.some_view);  // Match the ID with the TextView ID in your layout
        registerForContextMenu(someView);

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
    }

    // This method will be called to create the context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Inflate the context menu from the XML resource
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // This method will be called when an item is selected from the context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle item selections using if-else
        if (item.getItemId() == R.id.xml_option_copy) {
            Toast.makeText(this, "This text has been copied", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.xml_option_delete) {
            Toast.makeText(this, "This text has been deleted", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

}
