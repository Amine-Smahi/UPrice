package com.jetlight.uprice;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PhaseTwoActivity extends AppCompatActivity {

    TextView clock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_two);
        clock = (TextView) findViewById(R.id.clock);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                if ((millisUntilFinished/1000)  >= 10) {
                    clock.setText("00:" + (millisUntilFinished/1000));
                } else {
                    clock.setText("00:0" + (millisUntilFinished/1000));
                }
            }

            public void onFinish() {
                //   mTextField.setText("done!");
            }
        }.start();
    }
}
