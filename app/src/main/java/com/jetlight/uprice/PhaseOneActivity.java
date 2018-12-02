package com.jetlight.uprice;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jetlight.uprice.Models.Product;

import java.util.Random;

import static com.jetlight.uprice.Models.ProductsSeed.products;

public class PhaseOneActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    int productPrice;
    EditText editText;
    TextView clock;
    int [] playersPrices;
    static int j=0;
    CountDownTimer countDownTimer;
    ViewDialog alert = new ViewDialog();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_one);
        imageView = (ImageView)findViewById(R.id.ImageViewproductImage);
        textView = (TextView)findViewById(R.id.TextViewproductName);
        editText = (EditText)findViewById(R.id.EditTextproductPrice);
        clock = (TextView) findViewById(R.id.clock);
        Intent intent = getIntent();
        playersPrices = new int[intent.getIntExtra("playersCount",0)];
        settingInfo();
    }

    @Override
    protected void onStart() {
        super.onStart();
        timeUp();
    }

    void settingInfo(){
        if(products.size()!=0) {
            int randomIndex = new Random().nextInt(products.size());
            Product product = products.get(randomIndex);
            imageView.setImageDrawable(getResources().getDrawable(product.getImageLink()));
            textView.setText(product.getName());
            productPrice = product.getPrice();
            ViewDialog alert = new ViewDialog();
            playerSelection();
            products.remove(randomIndex);
        }
        else {
            alert.showDialog(PhaseOneActivity.this, "  Congrats \n Player 1 won!  ");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(PhaseOneActivity.this, PhaseTwoActivity.class);
                    startActivity(intent);
                }
            }, 1500);
        }
    }

    public void submitPrice(View view) {
        playersPrices[j]=Integer.parseInt(editText.getText().toString());
        editText.setText("");
        passTurn();
    }

    private void passTurn() {
        timeUp();
        j++;
        if(j==playersPrices.length){
            j=0;
            winner();
        }
        else {
            playerSelection();
        }
    }

    private void winner() {
        settingInfo();
    }

    public void Restart(View view) {
        Intent intent = new Intent(this,PlayersActivity.class);
        startActivity(intent);
    }
    void timeUp()
    {
        countDownTimer = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                if ((millisUntilFinished/1000)  >= 10) {
                    clock.setText("00:" + (millisUntilFinished/1000));
                }else if ((millisUntilFinished/1000) == 1){
                    clock.setText("00:01");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            clock.setText("00:00");
                        }
                    }, 1000);
                }
                else {
                    clock.setText("00:0" + (millisUntilFinished/1000));
                }
            }

            public void onFinish() {
                //   mTextField.setText("done!");
            }
        };
        countDownTimer.cancel();
        countDownTimer.start();
    }
    void playerSelection()
    {
        if(j==0){
            alert.showDialog(PhaseOneActivity.this, "  Player 1 Turn  ");
        }
        else if(j==1){
            alert.showDialog(PhaseOneActivity.this, "  Player 2 Turn  ");
        }
        else if(j==2) {
            alert.showDialog(PhaseOneActivity.this, "  Player 3 Turn  ");
        }
        else {
            alert.showDialog(PhaseOneActivity.this, "  Player 4 Turn  ");
        }
    }
}
