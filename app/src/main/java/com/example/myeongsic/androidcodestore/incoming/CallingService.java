package com.example.myeongsic.androidcodestore.incoming;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.myeongsic.androidcodestore.R;


/**
 * Created by Lim on 2016-10-02.
 */

public class CallingService extends Service{




    protected View rootView;
    protected View rootView_after;
    private TextView tv_call_number;
    private String call_number;
    private WindowManager.LayoutParams params;
    private WindowManager windowManager;
    public static final String EXTRA_CALL_NUMBER = "call_number"; //static 다른 class에서 쓸수있다. import extend안하고

    //좌표값을 정해줘서 위치를 지정해주는것..
    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.4); //Display 사이즈의 90%
        //윈도우 위치 조절
        params = new WindowManager.LayoutParams(
                width,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                PixelFormat.TRANSLUCENT);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        rootView = layoutInflater.inflate(R.layout.service_call_before, null);
        rootView_after = layoutInflater.inflate(R.layout.service_call_after, null);

        //뷰페이저 설계
        //xml디자인

        Button button = (Button) rootView.findViewById(R.id.CallingService_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display display = windowManager.getDefaultDisplay();
                int width = (int) (display.getWidth() * 0.9); //Display 사이즈의 90%
                int hieght = (int) (display.getWidth() * 0.6); //Display 사이즈의 90%
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                        width,
                        hieght,
                        WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                        PixelFormat.TRANSLUCENT);
                windowManager.addView(rootView_after,lp);
            }
        });

        tv_call_number = (TextView) rootView.findViewById(R.id.popup_call_top);
        //드래그 하는 부분
        //setDraggable();
    }

    //시작하는 부분 , 실행시키는부분
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        windowManager.addView(rootView, params);

        if (intent != null) {

            call_number = intent.getExtras().getString(EXTRA_CALL_NUMBER);
            if (!TextUtils.isEmpty(call_number)) {
                tv_call_number.setText(call_number);
            }
        }
        return START_REDELIVER_INTENT;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
