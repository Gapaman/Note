package com.example.note;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.note.notes.NotesFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_container);

        if (savedInstanceState == null) {
            Fragment fragment = new NotesFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_container, fragment)
                    .commit();
        }
    }
}