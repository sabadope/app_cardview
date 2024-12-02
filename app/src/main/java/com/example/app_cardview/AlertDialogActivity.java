package com.example.app_cardview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity {

    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);  // Ensure the layout file name matches your XML file

        myButton = findViewById(R.id.dialog);  // Find your button by ID

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show the alert dialog
                AlertDialog dialog = createDialog();
                dialog.show();
            }
        });

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

    // Method to create an AlertDialog
    private AlertDialog createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to proceed?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            Toast.makeText(AlertDialogActivity.this, "Clicked YES", Toast.LENGTH_LONG).show();
        });
        builder.setNegativeButton("No", (dialogInterface, i) -> {
            Toast.makeText(AlertDialogActivity.this, "Clicked NO", Toast.LENGTH_LONG).show();
        });
        return builder.create();
    }
}
