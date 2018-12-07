package com.jetlight.uprice;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jetlight.uprice.Models.Product;

import java.util.Random;

import static com.jetlight.uprice.Models.ProductsSeed.products;

public class PhaseTwoActivity extends AppCompatActivity {

    Product product;
    TextView clock;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_two);
        clock = (TextView) findViewById(R.id.clock);
        imageView = (ImageView) findViewById(R.id.imageView2);
        Intent intent = getIntent();

    }
   /* void settingInfo(){
        if(products.size()!=0) {
            int randomIndex = new Random().nextInt(products.size());
            product = products.get(randomIndex);
            imageView.setImageDrawable(getResources().getDrawable(product.getImageLink()));
            textView.setText(product.getName());
            productPrice = product.getPrice();
            playerSelection();
            products.remove(randomIndex);
        }
        else {
            winnersPhaseOne();
            ViewDialog.showDialog(PhaseOneActivity.this, "  Congrats \n Player" + winner1 + " and Player" + winner2 + " won!  ", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PhaseOneActivity.this,PhaseTwoActivity.class);
                    intent.putExtra("winner1",winner1);
                    intent.putExtra("winner2",winner2);
                    startActivity(intent);
                }
            });

        }
    }*/
    public void Restart(View view) {
        Intent intent = new Intent(this,PlayersActivity.class);
        startActivity(intent);
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

    public void WinnerTransaction(View view) {
        Intent intent = new Intent(this,WinnerActivity.class);
        startActivity(intent);
    }
}
