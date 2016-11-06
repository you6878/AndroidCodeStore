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
        Log.d(TAG, "onRceive()");

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state.equals(mLastState)) {//에러부분,중복작동방지
            return;
        } else { //불러오는부분
            mLastState = state;
            if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER); //번호가져오기
                Intent serviceIntent = new Intent(context, CallingService.class);
                serviceIntent.putExtra(CallingService.EXTRA_CALL_NUMBER, incomingNumber);
                context.startService(serviceIntent);
            }
        }
    }


}
