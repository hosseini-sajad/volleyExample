package com.example.sajad.volleyexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sajad.volleyexample.R;
import com.example.sajad.volleyexample.adapter.RecyclerAdapter;
import com.example.sajad.volleyexample.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private List<Anime> mAnimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().show();

        mRecyclerView = findViewById(R.id.recycler);
        mAnimes = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObjectRequest = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObjectRequest = response.getJSONObject(i);
                        String name = jsonObjectRequest.getString("name");
                        String description = jsonObjectRequest.getString("description");
                        String rating = jsonObjectRequest.getString("Rating");
                        String categorie = jsonObjectRequest.getString("categorie");
                        String studio = jsonObjectRequest.getString("studio");
                        String image_url = jsonObjectRequest.getString("img");

                        Anime anime = new Anime(name, description, rating, categorie, studio, image_url);
                        mAnimes.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, mAnimes);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                mRecyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
