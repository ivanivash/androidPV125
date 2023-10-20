package com.example.malaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAvatar=findViewById(R.id.imgAvatar);
        String url = "https://kovbasa.itstep.click/images/mala.jpeg";
        Glide

                .with(this)
                .load(url)
                .apply(new RequestOptions().override(600))
                .into(imgAvatar);
    }
}