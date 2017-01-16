package com.example.myeongsic.androidcodestore;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;
import android.view.View;

import com.example.myeongsic.androidcodestore.alertdialog.AlertDialogActivity;
import com.example.myeongsic.androidcodestore.anim.AnimationActivity;
import com.example.myeongsic.androidcodestore.gallery.GalleryActivity;
import com.example.myeongsic.androidcodestore.permission.PermssionActivity;
import com.example.myeongsic.androidcodestore.pinchtozoom.PinchToZoomActivity;
import com.example.myeongsic.androidcodestore.webview.WebViewActivity;

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
    @BindView(R.id.getWebView)
    AppCompatButton getWebView;
    @BindView(R.id.getAnimationIntent)
    AppCompatButton getAnimationIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        getAnimationIntent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(view.getContext(), AnimationActivity.class);
                    intent.putExtra("X", motionEvent.getRawX());
                    intent.putExtra("Y", motionEvent.getRawY());
                    startActivity(intent);
                }
                return false;
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.requestPermssion, R.id.getPathFromGallery, R.id.getAlertDailogActivity, R.id.getIncomingService, R.id.getWebView, R.id.getAnimationIntent})
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
                startActivity(new Intent(this, PinchToZoomActivity.class));
                break;
            case R.id.getWebView:
                startActivity(new Intent(this, WebViewActivity.class));
                break;


        }
    }


}


