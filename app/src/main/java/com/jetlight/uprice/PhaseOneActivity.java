package com.jetlight.uprice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jetlight.uprice.Models.Product;

import java.util.ArrayList;
import java.util.Random;

public class PhaseOneActivity extends AppCompatActivity {

    ArrayList<Product> products =new ArrayList<>();
    ImageView imageView;
    TextView textView;
    int productPrice;
    EditText editText;
    int [] playersPrices;
    static int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_one);
        imageView = (ImageView)findViewById(R.id.ImageViewproductImage);
        textView = (TextView)findViewById(R.id.TextViewproductName);
        editText = (EditText)findViewById(R.id.EditTextproductPrice);
        Intent intent = getIntent();
        products.add(new Product("OMO",65, R.drawable.trump));
        products.add(new Product("toz",44,R.drawable.profile));
        playersPrices = new int[intent.getIntExtra("playersCount",0)];
        settingInfo();
    }

    void settingInfo(){
        int randomIndex= new Random().nextInt(products.size());
        Product product = products.get(randomIndex);
        imageView.setImageDrawable(getResources().getDrawable(product.getImageLink()));
        textView.setText(product.getName());
        productPrice = product.getPrice();
        products.remove(randomIndex);
    }

    public void submitPrice(View view) {
        playersPrices[j]=Integer.parseInt(editText.getText().toString());
        editText.setText("");
        passTurn();
    }

    private void passTurn() {
        j++;
        if(j==playersPrices.length){
            j=0;
            winner();
        }
    }

    private void winner() {
        settingInfo();
    }


}
