package com.example.sajad.volleyexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sajad.volleyexample.R;
import com.squareup.picasso.Picasso;

/**
 * Created by sajad on 8/2/2018.
 */
public class AnimeDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_detail);

        getSupportActionBar().hide();

        //get data from previous
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String categorie = getIntent().getStringExtra("categorie");
        String rate = getIntent().getStringExtra("rate");
        String studio = getIntent().getStringExtra("studio");
        String image = getIntent().getStringExtra("image");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsin_tool_bar);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView detail_name = findViewById(R.id.detail_name);
        TextView detail_description = findViewById(R.id.description);
        TextView detail_categorie = findViewById(R.id.detail_categorie);
        TextView detail_rate = findViewById(R.id.detail_rating);
        TextView detail_studio = findViewById(R.id.detail_studio);
        ImageView detail_image = findViewById(R.id.detail_image);

        //add title for collaps
        collapsingToolbarLayout.setTitle(name);

        //set valuse come from previous activity
        detail_name.setText(name);
        detail_description.setText(description);
        detail_categorie.setText(categorie);
        detail_rate.setText(rate);
        detail_studio.setText(studio);
        Picasso.get().load(image).placeholder(R.drawable.rating_background).error(R.drawable.rating_background).into(detail_image);
    }
}
