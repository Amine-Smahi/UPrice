package com.jetlight.uprice;

import android.content.Intent;
import android.net.Uri;
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

    public void playerSelected(View view) {
        Intent intent = new Intent(PlayersActivity.this, PhaseOneActivity.class);
        switch (view.getId()) {
            case R.id.imageButtonTwoPlayers:
                intent.putExtra("playersCount", 2);
                break;
            case R.id.p2:
                intent.putExtra("playersCount", 2);
                break;
            case R.id.p3:
                intent.putExtra("playersCount", 3);
                break;
            case R.id.imageButtonThreePlayers:
                intent.putExtra("playersCount", 3);
                break;
            case R.id.p4:
                intent.putExtra("playersCount", 4);
                break;
            case R.id.imageButtonFourPlayers:
                intent.putExtra("playersCount", 4);
                break;
            default:
                intent = null;
                break;
        }
        startActivity(intent);
    }
}