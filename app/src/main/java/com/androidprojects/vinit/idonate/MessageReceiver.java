package com.androidprojects.vinit.idonate;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.androidprojects.vinit.idonate.activities.TransferActivity;

import java.util.Arrays;

import okhttp3.internal.Util;

import static java.lang.Math.min;

/**
 * Created by ashis on 20-01-2018.
 */

public class MessageReceiver extends BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) {
                    return;
                }
                SmsMessage[] messages = new SmsMessage[pdus.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }
                String sender = messages[0].getOriginatingAddress();
                String message = sb.toString();
                message=message.toLowerCase();
                if(sender.contains("SBI")){
                    if(message.contains("debit") || message.contains("credit") || message.contains("purchase")){
                        String[] a= message.split(" ");
                        int ind=Arrays.binarySearch(a,"rs.");
                        if(ind<0)ind=Arrays.binarySearch(a,"inr");
                        int nearest=Utils.getParamI(context,Utils.NEAREST,10);
                        long amt=Long.parseLong(a[ind+1]);
                        long dntAmt=0;
                        while(dntAmt<amt)dntAmt+=nearest;
                        dntAmt-=amt;
                        dntAmt=min(dntAmt,amt);
                        if(dntAmt!=0){
                            NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"default")
                                    .setSmallIcon(R.drawable.ic_launcher_background)
                                    .setContentTitle("I.Donate")
                                    .setContentText("Mind to contribute \20B9 "+ a[ind+1] +"to your I.Donate Wallet.")
                                    .addAction(R.drawable.clear,"Cancel",getPI(context,false,0))
                                    .addAction(R.drawable.check,"OK",getPI(context,true,dntAmt));
                        }

                    }
                }
            }
        }
    }

    PendingIntent getPI(Context ctx,boolean dnt,long amount){
        Intent intent=new Intent(ctx, TransferActivity.class);
        intent.putExtra(Utils.DONATION_AMOUNT,dnt);
        if(dnt)intent.putExtra(Utils.DONATION_AMOUNT,amount);
        PendingIntent pi=PendingIntent.getActivity(ctx,0,intent,0);
        return pi;
    }
}
