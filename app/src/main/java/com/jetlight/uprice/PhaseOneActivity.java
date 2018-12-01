package com.jetlight.uprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PhaseOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_one);
    }

    public void SecondActivityTransaction(View v)
    {
        Intent intent = new Intent(this,PhaseTwoActivity.class);
        startActivity(intent);
    }
}
