package com.jetlight.uprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
    }

    public void FirstActivityTransaction(View view) {
        Intent intent = new Intent(this,PhaseOneActivity.class);
        startActivity(intent);

    }
}