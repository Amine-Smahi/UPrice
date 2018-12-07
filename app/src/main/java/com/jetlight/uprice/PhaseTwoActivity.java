package com.jetlight.uprice;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jetlight.uprice.Models.Product;

import java.util.Random;

import static com.jetlight.uprice.Models.ProductsSeed.products;

public class PhaseTwoActivity extends AppCompatActivity {

    int scorePlayer1 = 0;
    int player1Index;
    int player2Index;
    int scorePlayer2 = 0;
    static int j = 0;
    int productPrice;
    Product product;
    Button button1;
    Button button2;
    Button button3;
    TextView clock;
    TextView textViewProductName;
    ImageView imageView;
    static int indexCorrectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_two);
        clock = (TextView) findViewById(R.id.clock);
        imageView = (ImageView) findViewById(R.id.imageView2);
        /*Intent intent = getIntent();
        player1Index = intent.getIntExtra("winner1", 0);
        player2Index = intent.getIntExtra("winner2", 0);*/
        textViewProductName = (TextView) findViewById(R.id.textviewProductName);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        settingInfo();
    }

    void settingPriceInButtons() {
        int randomposition = new Random().nextInt(3);
        double firstWrongPrice;
        double secondWrongPrice;
        switch (randomposition) {
            case 0:
                button1.setText(product.getPrice());
                firstWrongPrice = product.getPrice() * 1.1;
                button2.setText(String.valueOf(firstWrongPrice));
                secondWrongPrice = product.getPrice() * 1.2;
                button3.setText(String.valueOf(secondWrongPrice));
                indexCorrectButton = 0;
                break;
            case 1:
                button2.setText(product.getPrice());
                firstWrongPrice = product.getPrice() * 0.9;
                button1.setText(String.valueOf(firstWrongPrice));
                secondWrongPrice = product.getPrice() * 1.1;
                button3.setText(String.valueOf(secondWrongPrice));
                indexCorrectButton = 1;
                break;
            case 2:
                button3.setText(product.getPrice());
                firstWrongPrice = product.getPrice() * 0.9;
                button2.setText(String.valueOf(firstWrongPrice));
                secondWrongPrice = product.getPrice() * 0.8;
                button3.setText(String.valueOf(secondWrongPrice));
                indexCorrectButton = 2;
                break;
            default:
                return;
        }
    }

    void settingInfo() {
        if (products.size() != 0) {
            int randomIndex = new Random().nextInt(products.size());
            product = products.get(randomIndex);
            imageView.setImageDrawable(getResources().getDrawable(product.getImageLink()));
            textViewProductName.setText(product.getName());
            productPrice = product.getPrice();
            playerSelection();
            products.remove(randomIndex);
            settingPriceInButtons();
        } else {
            winnersPhaseTwo();
        }
    }

    private void passTurn() {
        j++;
        if (j == 2) {
            j = 0;
        } else {
            playerSelection();
        }
    }

    public void winnersPhaseTwo() {
        if (scorePlayer1 > scorePlayer2) {
            ViewDialog.showDialog(PhaseTwoActivity.this, "  Congrats \n Player " + player1Index + " won!  ", null);
        } else {
            ViewDialog.showDialog(PhaseTwoActivity.this, "  Congrats \n Player " + player2Index + " won!  ", null);
        }
    }


    public void Restart(View view) {
        Intent intent = new Intent(this, PlayersActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                if ((millisUntilFinished / 1000) >= 10) {
                    clock.setText("00:" + (millisUntilFinished / 1000));
                } else {
                    clock.setText("00:0" + (millisUntilFinished / 1000));
                }
            }

            public void onFinish() {
                //   mTextField.setText("done!");
            }
        }.start();
    }

    /*
        public void WinnerTransaction(View view) {
            Intent intent = new Intent(this, WinnerActivity.class);
            startActivity(intent);
        }
    */
    void playerSelection() {
        if (j == 0) {
            ViewDialog.showDialog(PhaseTwoActivity.this, "  Player 1 Turn  ", null);
        } else if (j == 1) {
            ViewDialog.showDialog(PhaseTwoActivity.this, "  Player 2 Turn  ", null);
        }
    }

    public void submitClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                if (indexCorrectButton == 0 && j == 0) scorePlayer1++;
                if (indexCorrectButton == 0 && j == 1) scorePlayer2++;
                break;
            case R.id.button2:
                if (indexCorrectButton == 1 && j == 0) scorePlayer1++;
                if (indexCorrectButton == 1 && j == 1) scorePlayer2++;
                break;
            case R.id.button3:
                if (indexCorrectButton == 2 && j == 0) scorePlayer1++;
                if (indexCorrectButton == 2 && j == 1) scorePlayer2++;
                break;
        }
        passTurn();
        settingInfo();

    }
}
