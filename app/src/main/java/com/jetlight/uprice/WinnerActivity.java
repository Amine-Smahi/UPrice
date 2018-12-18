package com.jetlight.uprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    TextView winnerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Intent intent = getIntent();
        winnerName = (TextView)findViewById(R.id.winnerName);
        int temp=intent.getIntExtra("1",0);
        if(temp==1){
            winnerName.setText("Player 1");
        }else{
            winnerName.setText("Player 2");
        }
    }
    public void Restart(View view) {
        Intent intent = new Intent(this,PlayersActivity.class);
        startActivity(intent);
    }
}
