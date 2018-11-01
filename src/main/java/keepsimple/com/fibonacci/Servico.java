package keepsimple.com.fibonacci;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import java.util.ArrayList;

public class Servico extends Service {
    private ArrayList<Integer> listaFibonacci;
    private String aux = "";
    public String getAux() {
        return aux;
    }
    public void setAux(String aux) {
        this.aux = aux;
    }
    @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String numeroDigitado = extras.getString("numeroDigitado");
                int numero = Integer.parseInt(numeroDigitado);
                fibonacci(numero);
            }
        }
            return super.onStartCommand(intent, flags, startId);
        }
        @Override
        public void onDestroy() {

            Intent novaIntent = new Intent("Receiver");
            novaIntent.putExtra("fibonacci", aux);
            sendBroadcast(novaIntent);
            this.stopSelf();
            super.onDestroy();
        }
        private void fibonacci(int numero) {
            int a = 0;
            int b = 1;
            int c = 1;

                while (c <= numero) {
                    {
                        if(a+b>numero){
                            break;
                        }
                        aux = aux.concat(String.valueOf(c) + ",");
                        c = a + b;
                        a = b;
                        b = c;
                    }
                }
                onDestroy();
        }
}

