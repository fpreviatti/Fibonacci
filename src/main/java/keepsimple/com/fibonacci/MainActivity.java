package keepsimple.com.fibonacci;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.R.*;
import java.util.Vector;

public class MainActivity extends AppCompatActivity   {
    private EditText numeroDigitado;
    private Button botaoSubmit;
    private TextView textoId;
    private int numero;
    private String aux="";
    private String fibonacci="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroDigitado = findViewById(R.id.numeroId);
        botaoSubmit = findViewById(R.id.botaoId);
        textoId = findViewById(R.id.textoId);
        IntentFilter it = new IntentFilter();
        it.addAction("Receiver");
        registerReceiver(new Receiver(), it);

        botaoSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aux = numeroDigitado.getText().toString();

                if (aux.equals("")) {
                    Toast.makeText(MainActivity.this, "Você não digitou um número. Por gentileza digite um número entre 1 - 1000", Toast.LENGTH_SHORT).show();
                } else {
                    numero = Integer.parseInt(aux);
                    if (numero < 1 || numero > 1000) {
                        Toast.makeText(MainActivity.this, "Favor digitar um número entre 1 - 1000:", Toast.LENGTH_SHORT).show();
                    } else {
                        textoId.setText("");
                        Intent intent = new Intent(getApplicationContext(), Servico.class);
                        intent.putExtra("numeroDigitado", aux);
                        startService(intent);
                    }
                }
            }
        });
    }
    public class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    fibonacci = extras.getString("fibonacci");
                    String fibonacciAux = fibonacci.substring(0, fibonacci.length()-1);
                    textoId.setText(fibonacciAux);
                }
            }
        }
    }
}

