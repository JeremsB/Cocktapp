package com.mds.cocktapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mds.cocktapp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Intent intent = getIntent();
        //String message = "Drink n° : " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //TextView textView = findViewById(R.id.detail_textview);
        //textView.setText(message);
    }
}
