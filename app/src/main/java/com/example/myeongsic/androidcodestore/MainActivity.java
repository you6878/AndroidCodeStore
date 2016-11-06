package com.example.myeongsic.androidcodestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.example.myeongsic.androidcodestore.alertdialog.AlertDialogActivity;
import com.example.myeongsic.androidcodestore.gallery.GalleryActivity;
import com.example.myeongsic.androidcodestore.incoming.IncomingActivity;
import com.example.myeongsic.androidcodestore.permission.PermssionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.requestPermssion)
    AppCompatButton requestPermssion;
    @BindView(R.id.getPathFromGallery)
    AppCompatButton getPathFromGallery;
    @BindView(R.id.getAlertDailogActivity)
    AppCompatButton getAlertDailogActivity;
    @BindView(R.id.getIncomingService)
    AppCompatButton getIncomingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.requestPermssion, R.id.getPathFromGallery, R.id.getAlertDailogActivity,R.id.getIncomingService})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.requestPermssion:
                startActivity(new Intent(this, PermssionActivity.class));
                break;
            case R.id.getPathFromGallery:
                startActivity(new Intent(this, GalleryActivity.class));
                break;
            case R.id.getAlertDailogActivity:
                startActivity(new Intent(this, AlertDialogActivity.class));
                break;
            case R.id.getIncomingService:
                startActivity(new Intent(this, IncomingActivity.class));
                break;
        }
    }
}


