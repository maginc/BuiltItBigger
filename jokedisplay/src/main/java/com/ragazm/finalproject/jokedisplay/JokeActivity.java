package com.ragazm.finalproject.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");

        TextView jokeTextView = findViewById(R.id.textView);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }
}
