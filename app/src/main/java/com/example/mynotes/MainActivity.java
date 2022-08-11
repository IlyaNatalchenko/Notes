package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        NoteFragment1 noteFragment1 = new NoteFragment1();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, noteFragment1)
                .commit();
    }
    private void initViews() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        initOnClickListeners();
    }
    private void initOnClickListeners() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.button2) {
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.button3) {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
        }
    }

}