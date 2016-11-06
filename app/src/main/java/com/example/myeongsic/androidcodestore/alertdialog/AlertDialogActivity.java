package com.example.myeongsic.androidcodestore.alertdialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.myeongsic.androidcodestore.R;

public class AlertDialogActivity extends AppCompatActivity {


    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        //getXml
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View beforeView = layoutInflater.inflate(R.layout.item_alertdialog_before, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(beforeView);
        //builder.setTitle("Title"); set Title
        alertDialog = builder.create();
        alertDialog.show();

        //setScreentSize for Dialog
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 추가 기능 lp.copyFrom(dialog.getWindow().getAttributes()); //현재 싸이즈 받아오기
        // 추가 기능 lp.gravity = Gravity.CENTER; //Attrbute Center
        alertDialog.getWindow().setAttributes(lp);


        Button button = (Button) beforeView.findViewById(R.id.alertDialog_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //getXml
                LayoutInflater layoutInflater = LayoutInflater.from(view.getContext());
                View afterview = layoutInflater.inflate(R.layout.item_alertdialog_after, null);


                //setView
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setView(afterview);
                alertDialog = builder.create();
                alertDialog.show();

                //get Pixel
                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

                //setScreentSize for Dialog
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.width = displaymetrics.widthPixels;
                lp.height = (int) (displaymetrics.heightPixels * 0.6);
                // 추가 기능 lp.gravity = Gravity.CENTER;
                alertDialog.getWindow().setAttributes(lp);


            }
        });


    }
}
