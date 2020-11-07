package com.example.juegoalgoritmica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class juegoGrafico2 extends AppCompatActivity {

    boolean isBabyDead(int ax, int ay, int bx, int by){
        int s = (ax*by - ay*bx);
        s = Math.abs(s);
        return s==0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_grafico2);

        ImageButton btnN = (ImageButton) findViewById(R.id.equis);
        ImageButton btnY = (ImageButton) findViewById(R.id.check);

        TextView puntoBaby = (TextView) findViewById(R.id.punto);
        TextView anguloAuto = (TextView) findViewById(R.id.angulo);

        int puntoXB = (int) (Math.random()*(9 - 0)) + 1;
        int puntoYB = (int) (Math.random()*(9 - 0)) + 1;

        int puntoXC = puntoXB;
        int puntoYC = (int) ((Math.random()*(9 - 0 )) +  1);

        puntoBaby.setText(puntoXB+", "+puntoYB);
        anguloAuto.setText((int)((Math.atan2(puntoYC,puntoXC))*(180/Math.PI))+"°");

        if(isBabyDead(puntoXC,puntoYC,puntoXB, puntoYB)){

            btnN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!... lo aplasta",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico3.class);
                    startActivityForResult(intent, 0);
                }
            });

            btnY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :(... lo aplasta",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico3.class);
                    startActivityForResult(intent, 0);
                }
            });

        }else{


            btnN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :(... sobrevive",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico3.class);
                    startActivityForResult(intent, 0);
                }
            });

            btnY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!... sobrevive",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico3.class);
                    startActivityForResult(intent, 0);
                }
            });

        }


    }
}