package com.example.juegoalgoritmica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class juegoGrafico1 extends AppCompatActivity {

    int puntosAx[] = new int[3];
    int puntosAy[] = new int[3];
    int puntosRx[] = new int[3];
    int puntosRy[] = new int[3];

    double areaDelTriangulo(int ax,int ay, int bx,int by,int cx,int cy){
        double s= Math.sqrt((bx-ax)*(bx-ax) + (by-ay)*(by-ay)) + Math.sqrt((cx-ax)*(cx-ax) + (cy-ay)*(cy-ay))
                + Math.sqrt((cx-bx)*(cx-bx) + (cy-by)*(cy-by));
        return  Math.sqrt(s*(s-(Math.sqrt((bx-ax)*(bx-ax) + (by-ay)*(by-ay))))*(s-(Math.sqrt((cx-ax)*(cx-ax)
                + (cy-ay)*(cy-ay))))*(s-(Math.sqrt((cx-bx)*(cx-bx) + (cy-by)*(cy-by)))));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_grafico1);

        ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton);
        ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton2);

        TextView puntoA1 = (TextView) findViewById(R.id.puntoAzul1);
        TextView puntoA2 = (TextView) findViewById(R.id.puntoAzul2);
        TextView puntoA3 = (TextView) findViewById(R.id.puntoAzul3);

        TextView puntoR1 = (TextView) findViewById(R.id.puntoRojo1);
        TextView puntoR2 = (TextView) findViewById(R.id.puntoRojo2);
        TextView puntoR3 = (TextView) findViewById(R.id.puntoRojo3);

        for(int i=0 ; i<3 ;i++) {
            int x = (int) (Math.random() * (9 - 0)) + 1;
            int y = (int) (Math.random() * (9 - 0)) + 1;
            puntosAx[i]=x;
            puntosAy[i]=y;

        }
        for(int i=0 ; i<3 ;i++) {
            int x = (int) (Math.random() * (9 - 0)) + 1;
            int y = (int) (Math.random() * (9 - 0)) + 1;
            puntosRx[i]=x;
            puntosRy[i]=y;
        }

        puntoA1.setText(puntosAx[0] + ", " + puntosAy[0]);
        puntoR1.setText(puntosRx[0] + ", " + puntosRy[0]);

        puntoA2.setText(puntosAx[1] + ", " + puntosAy[1]);
        puntoR2.setText(puntosRx[1] + ", " + puntosRy[1]);

        puntoA3.setText(puntosAx[2] + ", " + puntosAy[2]);
        puntoR3.setText(puntosRx[2] + ", " + puntosRy[2]);

        double valor1 = areaDelTriangulo(puntosAx[0], puntosAy[0], puntosAx[1], puntosAy[1],
                puntosAx[2],puntosAy[2]);

        double valor2 = areaDelTriangulo(puntosRx[0], puntosRy[0], puntosRx[1], puntosRy[1],
                puntosRx[2],puntosRy[2]);


        if(valor1>valor2){
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico2.class);
                    startActivityForResult(intent, 0);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :(",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico2.class);
                    startActivityForResult(intent, 0);
                }
            });
        }else if(valor1<valor2){
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :(",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico2.class);
                    startActivityForResult(intent, 0);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico2.class);
                    startActivityForResult(intent, 0);
                }
            });
        }else{
            Toast mensaje1 =
                    Toast.makeText(getApplicationContext(),"Son iguales, ambos son correctos :)",Toast.LENGTH_LONG);
            mensaje1.show();


        }
    }
}