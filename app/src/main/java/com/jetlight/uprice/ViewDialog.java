package com.jetlight.uprice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by moham on 01/12/2018.
 */

public class ViewDialog {

    public static void showDialog(Activity activity, String msg, View.OnClickListener action){

        AlertDialog.Builder b = new AlertDialog.Builder(activity);
        View v = activity.getLayoutInflater().inflate(R.layout.dialog, null);
        TextView textView = (TextView)v.findViewById(R.id.text_dialog);
        Button btn =(Button)v.findViewById(R.id.btn_dialog);
        textView.setText(msg);
        b.setView(v);
        final AlertDialog a = b.create();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.hide();
            }
        });
        if(action != null)
        btn.setOnClickListener(action);
        a.show();
    }
}