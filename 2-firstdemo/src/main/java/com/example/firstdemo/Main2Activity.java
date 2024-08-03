package com.example.firstdemo;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.firstdemo.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    public static String RECEIVED_MESSAGE = "Received message";

    private ActivityMain2Binding binding;

    private static int counter2 = 0;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Intent intent = getIntent();
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.previousMessage.setText(intent.getStringExtra(MainActivity.MESSAGE));

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPressed();
            }
        });

        // Handle the back press in API > Tiramisu
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(RECEIVED_MESSAGE, "Hello from the second activity.");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.counter2.setText("Page View: " + (++counter2) + " times");
    }

    public void buttonPressed(){
        Intent intent = new Intent();
        intent.setAction("ThirdActivity");
        startActivity(intent);
    }
}
