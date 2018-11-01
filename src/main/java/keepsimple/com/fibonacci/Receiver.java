package keepsimple.com.fibonacci;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    public Receiver() {
    }
    private String fibonacci="";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null) {
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            fibonacci = extras.getString("fibonacci");
        }
    }
}
