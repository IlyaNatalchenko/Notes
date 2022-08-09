package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteFragment1 noteFragment1 = new NoteFragment1();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, noteFragment1)
                .commit();
    }

}