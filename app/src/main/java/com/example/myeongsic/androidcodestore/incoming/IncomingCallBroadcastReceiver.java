package com.example.myeongsic.androidcodestore.incoming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Lim on 2016-10-02.
 */

public class IncomingCallBroadcastReceiver extends BroadcastReceiver{

    private static final String TAG = "IncomingCall";
    private static String mLastState;

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state.equals(TelephonyManager.EXTRA_STATE_IDLE))
        {
            Log.d(TAG,"통화 종료 후 구현 ...");
        }
        else if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {

            Log.d(TAG,"통화 벨 울릴 시 구현 ...");

            if (state.equals(mLastState)) {//에러부분,중복작동방지
                return;
            } else { //불러오는부분
                mLastState = state;
                if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                    Intent serviceIntent = new Intent(context, CallingService.class);
                    context.startService(serviceIntent);
                }
            }

        }
        else if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
        {
            Log.d(TAG,"통화 중 상태일 때 구현 ...");

        }
        else if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL))
        {

            Log.d(TAG,"전화를 걸때 상태 구현 ...");
        }



    }


}


/*
*  String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER); //번호가져오기
*
* */