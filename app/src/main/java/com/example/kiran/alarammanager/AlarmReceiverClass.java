package com.example.kiran.alarammanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.widget.Toast;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by Kiran on 20-11-2015.
 */
public class AlarmReceiverClass extends BroadcastReceiver
{
   /* Intent intentcam;
    Bundle b;
    MainActivity mv;
    AlarmReceiverClass(Bundle b)
    {
        this.b=b;
         mv=new MainActivity();
    }*/
    @Override
    public void onReceive(Context context, Intent intent) {
        /*intentcam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(null,intentcam,1,null);
//        startActivityForResult(intentcam, 1,b);*/
        Toast.makeText(context,"Alarm Tiggered from AlarmaReceiverClass",Toast.LENGTH_SHORT).show();
    }
}
