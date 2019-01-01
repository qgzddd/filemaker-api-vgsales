package com.joselopezrosario.vgsales.filemaker_api_vgsales.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.joselopezrosario.vgsales.filemaker_api_vgsales.R;
import com.joselopezrosario.vgsales.filemaker_api_vgsales.api.FMApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        final Button findButton = findViewById(R.id.find);
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });
    }

    public void find() {
    }

    private String createFindQuery() {
        TextInputEditText vPlatform = findViewById(R.id.platform_input);
        TextInputEditText vPublisher = findViewById(R.id.publisher_input);
        TextInputEditText vGenre = findViewById(R.id.genre_input);
        TextInputEditText vName = findViewById(R.id.name_input);
        TextInputEditText vLimit = findViewById(R.id.limit_input);
        TextInputEditText vOffset = findViewById(R.id.offset_input);
        String platform = "";
        String publisher = "";
        String genre = "";
        String name = "";
        String limit = "";
        String offset = "";
        if (vPlatform.getText() != null) {
            platform = vPlatform.getText().toString();
        }
        if (vPublisher.getText() != null) {
            publisher = vPublisher.getText().toString();
        }
        if (vGenre.getText() != null) {
            genre = vGenre.getText().toString();
        }
        if (vName.getText() != null) {
            name = vName.getText().toString();
        }
        if (vLimit.getText() != null) {
            limit = vLimit.getText().toString();
        }
        if (vOffset.getText() != null) {
            offset = vOffset.getText().toString();
        }
        try {
            JSONObject json = new JSONObject();
            JSONArray queryArray = new JSONArray();
            JSONObject pairs = new JSONObject()
                    .put(FMApi.FIELD_PLATFORM, "=" + platform)
                    .put(FMApi.FIELD_PUBLISHER, "=" + publisher)
                    .put(FMApi.FIELD_GENRE, "=" + genre)
                    .put(FMApi.FIELD_NAME, "=" + name);
            queryArray.put(pairs);
            json.put("query", queryArray);
            json.put("limit", limit);
            json.put("offset", offset);
            return json.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
