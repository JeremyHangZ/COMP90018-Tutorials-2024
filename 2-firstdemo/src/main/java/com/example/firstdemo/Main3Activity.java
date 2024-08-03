package com.example.firstdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstdemo.databinding.ActivityMain3Binding;

public class Main3Activity extends AppCompatActivity {
    private ActivityMain3Binding binding;

    private static int counter3 = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Button button = binding.button2;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPressed();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        binding.counter3.setText("Page View: " + (++counter3) + " times");
    }

    private void buttonPressed() {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
