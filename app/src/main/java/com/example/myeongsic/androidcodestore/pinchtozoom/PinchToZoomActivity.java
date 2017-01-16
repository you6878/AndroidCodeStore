package com.example.myeongsic.androidcodestore.pinchtozoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.myeongsic.androidcodestore.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PinchToZoomActivity extends AppCompatActivity {
    PhotoViewAttacher mAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinch_to_zoom);
        ImageView imageView = (ImageView)findViewById(R.id.pinch_to_zoom_ImageView);
        imageView.setBackgroundResource(R.drawable.ic_launcher);
        mAttacher = new PhotoViewAttacher(imageView);
        mAttacher.update();
    }

}
