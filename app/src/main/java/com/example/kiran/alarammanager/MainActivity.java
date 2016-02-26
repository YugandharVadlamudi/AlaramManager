package com.example.kiran.alarammanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.GregorianCalendar;

public class MainActivity extends Activity {
Intent intentcam;
    ImageView im;
    Bitmap photo;
    AlarmManager am;
    Intent intent;
    long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameraintent);
        im=(ImageView)findViewById(R.id.iv);
       alramManager();
//        AlarmReceiverClass am=new AlarmReceiverClass(savedInstanceState);

//        Log.d("bundle name:",savedInstanceState.toString());
    }
    public void CamIntentCall(View view)
    {
        intentcam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentcam, 1);
    }
    public  void alramManager(){
        am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        intent=new Intent(this,AlarmReceiverClass.class);
        time= new GregorianCalendar().getTimeInMillis();
        am.setRepeating(AlarmManager.RTC_WAKEUP, time, 3 * 1000, PendingIntent.getBroadcast(this, 0, intent, 0));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
             photo=(Bitmap) data.getExtras().get("data");
            im.setImageBitmap(photo);
            Log.d("name photo", photo.toString());
    }
}
