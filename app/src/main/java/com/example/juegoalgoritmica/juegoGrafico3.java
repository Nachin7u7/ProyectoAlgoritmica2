package com.example.juegoalgoritmica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class juegoGrafico3 extends AppCompatActivity {

    int distanciaEstrellas(int x1,int y1, int x2, int y2){
        int x = x1-x2;
        int y = y1-y2;
        return (int) Math.hypot(x,y);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_grafico3);

        TextView punto1 = (TextView) findViewById(R.id.punto1);
        TextView punto2 = (TextView) findViewById(R.id.punto2);

        Button respuesta1 = (Button) findViewById(R.id.respuesta1);
        Button respuesta2 = (Button) findViewById(R.id.respuesta2);

        int punto1X = (int) (Math.random()*(9-0)+1);
        int punto1Y = (int) (Math.random()*(9-0)+1);
        punto1.setText(punto1X+", "+punto1Y);
        int punto2X = (int) (Math.random()*(9-0)+1);
        int punto2Y = (int) (Math.random()*(9-0)+1);
        punto2.setText(punto2X+", "+punto2Y);

        int ans = (int) (Math.random()*(2));

        if(ans == 1){
            int correctAns = distanciaEstrellas(punto1X,punto1Y,punto2X,punto2Y);
            respuesta1.setText(correctAns+" años luz");
            int wrongAns =(int)(Math.random()*(12-0));
            respuesta2.setText(wrongAns + " años luz");
            if(correctAns == wrongAns){
                wrongAns++;
                respuesta2.setText(wrongAns + " años luz");
            }
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();
                }
            });
            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto... :(",Toast.LENGTH_LONG);
                    mensaje1.show();
                }
            });

        }else{

            respuesta2.setText(distanciaEstrellas(punto1X,punto1Y,punto2X,punto2Y)+" años luz");
            respuesta1.setText((Math.random()*(12-0)+1)+" años luz");

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();
                }
            });
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto... :(",Toast.LENGTH_LONG);
                    mensaje1.show();
                }
            });

        }

    }
}