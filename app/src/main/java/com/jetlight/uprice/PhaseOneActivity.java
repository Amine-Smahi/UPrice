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
import android.widget.Toast;

import com.jetlight.uprice.Models.Product;

import java.util.Random;

import static com.jetlight.uprice.Models.ProductsSeed.products;

public class PhaseOneActivity extends AppCompatActivity {

    int winner2;
    int winner1;
    ImageView imageView;
    TextView textView;
    int productPrice;
    Product product;
    EditText editText;
    static int indexGagnant = 0;
    TextView clock;
    int[] playersScore;
    int[] playersPrices;
    static int j = 0;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_one);
        imageView = (ImageView) findViewById(R.id.ImageViewproductImage);
        textView = (TextView) findViewById(R.id.TextViewproductName);
        editText = (EditText) findViewById(R.id.EditTextproductPrice);
        clock = (TextView) findViewById(R.id.clock);
        Intent intent = getIntent();
        playersPrices = new int[intent.getIntExtra("playersCount", 0)];
        playersScore = new int[intent.getIntExtra("playersCount", 0)];
        settingInfo();
    }

    @Override
    protected void onStart() {
        super.onStart();
        timeUp();
    }

    void settingInfo() {
        if (products.size() >= 6) {
            int randomIndex = new Random().nextInt(products.size());
            product = products.get(randomIndex);
            imageView.setImageDrawable(getResources().getDrawable(product.getImageLink()));
            textView.setText(product.getName());
            productPrice = product.getPrice();
            playerSelection();
            products.remove(randomIndex);
        } else {
            winnersPhaseOne();
            ViewDialog.showDialog(PhaseOneActivity.this, "  Congrats \n Player" + winner1 + " and Player" + winner2 + " won!  ", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(PhaseOneActivity.this, PhaseTwoActivity.class);
                    intent1.putExtra("winner1", winner1);
                    intent1.putExtra("winner2", winner2);
                    startActivity(intent1);
                }
            });

        }
    }

    public void submitPrice(View view) {
        playersPrices[j] = Integer.parseInt(editText.getText().toString());
        editText.setText("");
        passTurn();
    }

    private void passTurn() {
        timeUp();
        j++;
        if (j == playersPrices.length) {
            j = 0;
            winner();
        } else {
            playerSelection();
        }
    }

    private void winner() {
        int min = -1;

        for (int i = 0; i < playersPrices.length; i++) {
            if (playersPrices[i] <= product.getPrice() && playersPrices[i] > min) {
                min = playersPrices[i];
                indexGagnant = i;
            }
        }
        settingInfo();
        if (min != -1) {
            playersScore[indexGagnant]++;
            ViewDialog.showDialog(PhaseOneActivity.this, "  Congrats \n Player " + (indexGagnant + 1) + " won!  ", null);
        }

    }

    private void winnersPhaseOne() {
        winner1 = 0;
        winner2 = playersScore.length - 1;
        for (int i = 1; i < playersScore.length; i++) {
            if (playersScore[i] > playersScore[winner1]) {
                winner1 = i;
            }
        }
        for (int i = 0; i < playersScore.length - 1; i++) {
            if (i != winner1 && playersScore[i] > playersScore[winner2]) {
                winner2 = i;
            }
        }
        winner1++;
        winner2++;
        //Toast.makeText(this,"Les finalistes sont:"+ (winner1+1) + " et " + (winner2+1),Toast.LENGTH_SHORT).show();

    }

    public void Restart(View view) {
        Intent intent = new Intent(this, PlayersActivity.class);
        startActivity(intent);
    }

    void timeUp() {
        countDownTimer = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                if ((millisUntilFinished / 1000) >= 10) {
                    clock.setText("00:" + (millisUntilFinished / 1000));
                } else if ((millisUntilFinished / 1000) == 1) {
                    clock.setText("00:01");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            clock.setText("00:00");
                        }
                    }, 1000);
                } else {
                    clock.setText("00:0" + (millisUntilFinished / 1000));
                }
            }

            public void onFinish() {
                //   mTextField.setText("done!");
            }
        };
        countDownTimer.cancel();
        countDownTimer.start();
    }

    void playerSelection() {
        if (j == 0) {
            ViewDialog.showDialog(PhaseOneActivity.this, "  Player 1 Turn  ", null);
        } else if (j == 1) {
            ViewDialog.showDialog(PhaseOneActivity.this, "  Player 2 Turn  ", null);
        } else if (j == 2) {
            ViewDialog.showDialog(PhaseOneActivity.this, "  Player 3 Turn  ", null);
        } else {
            ViewDialog.showDialog(PhaseOneActivity.this, "  Player 4 Turn  ", null);
        }
    }
}