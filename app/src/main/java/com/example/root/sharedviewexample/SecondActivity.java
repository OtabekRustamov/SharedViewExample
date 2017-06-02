package com.example.root.sharedviewexample;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        View smallImageView = findViewById(R.id.smallerImageView);
        View editText = findViewById(R.id.editText);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            smallImageView.setTransitionName("tran_name");
        }
    }
}
