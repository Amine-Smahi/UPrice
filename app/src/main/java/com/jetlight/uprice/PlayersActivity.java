package com.jetlight.uprice;

import android.content.Intent;
<<<<<<< HEAD
=======
import android.net.Uri;
>>>>>>> 645337d597c60c03c7be044578bc546e05e5e2ba
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jetlight.uprice.Models.Product;

import java.util.ArrayList;

public class PlayersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
    }

<<<<<<< HEAD
    public void FirstActivityTransaction(View view) {
        Intent intent = new Intent(this,PhaseOneActivity.class);
        startActivity(intent);

=======
    public void playerSelected(View view) {
        Intent intent = new Intent(PlayersActivity.this, PhaseOneActivity.class);
        switch (view.getId()) {
            case R.id.imageButtonTwoPlayers:
                intent.putExtra("playersCount", 2);
                break;
            case R.id.imageButtonThreePlayers:
                intent.putExtra("playersCount", 3);
                break;
            case R.id.imageButtonFourPlayers:
                intent.putExtra("playersCount", 4);
                break;
            default:
                intent = null;
                break;
        }
        startActivity(intent);
>>>>>>> 645337d597c60c03c7be044578bc546e05e5e2ba
    }
}