package com.example.juegoalgoritmica;

import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class juegoGrafico5 extends AppCompatActivity {

    class Point{
        double x, y;
        Point(){}

        Point(double a,double b) {
            x = a;
            y = b;
        }

    };

    double cross(Point V, Point U) {
        return V.x * U.y - V.y * U.x;
    }

   Point operatorMinus(Point a, Point b){
        return new Point(a.x - b.x, a.y-b.y);
    }

    double area(Point A, Point B, Point C) {
        return cross(operatorMinus(C, A),operatorMinus(B, A));
    }

    double areaPoligono(Point poligono[]) {
        int nroPoints = poligono.length;
        double areaTotal = 0;
        for(int i = 1; i < nroPoints - 1; i++) {
            areaTotal += area(poligono[0],poligono[i],poligono[i+1]);
        }
        return Math.abs(areaTotal/2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_grafico5);

        ImageButton bt1 = (ImageButton) findViewById(R.id.btn1);
        ImageButton bt2 = (ImageButton) findViewById(R.id.btn2);

        TextView puntosS[] = new TextView[5];
        puntosS[0]= (TextView) findViewById(R.id.pt1s);
        puntosS[1]= (TextView) findViewById(R.id.pt2s);
        puntosS[2]= (TextView) findViewById(R.id.pt3s);
        puntosS[3]= (TextView) findViewById(R.id.pt4s);
        puntosS[4]= (TextView) findViewById(R.id.pt5s);

        TextView puntosJ[] = new TextView[5];
        puntosJ[0]= (TextView) findViewById(R.id.pt1j);
        puntosJ[1]= (TextView) findViewById(R.id.pt2j);
        puntosJ[2]= (TextView) findViewById(R.id.pt3j);
        puntosJ[3]= (TextView) findViewById(R.id.pt4j);
        puntosJ[4]= (TextView) findViewById(R.id.pt5j);

        Point poligonSaturno[] = new Point[5];

        for(int i = 0 ; i < 5 ; i++){
            double x = (int)(Math.random()*(9-0)+1);
            double y = (int)(Math.random()*(9-0)+1);
            poligonSaturno[i] = new Point(x, y);
            puntosS[i].setText((int)(x)+", "+(int)(y));
        }

        Point poligonJupiter[] = new Point[5];

        for(int i = 0 ; i < 5 ; i++){
            double x = (int)(Math.random()*(9-0)+1);
            double y = (int)(Math.random()*(9-0)+1);
            poligonJupiter[i] = new Point(x, y);
            puntosJ[i].setText((int)(x)+", "+(int)(y));
        }

        if(areaPoligono(poligonJupiter) > areaPoligono(poligonSaturno)){

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :( ...",Toast.LENGTH_LONG);
                    mensaje1.show();

                    //Intent intent = new Intent(v.getContext(), juegoGrafico(nivel).class);
                    //startActivityForResult(intent, 0);

                }
            });

            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();

                    //Intent intent = new Intent(v.getContext(), juegoGrafico(nivel).class);
                    //startActivityForResult(intent, 0);

                }
            });

        }else if(areaPoligono(poligonJupiter) < areaPoligono(poligonSaturno)){

            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :( ...",Toast.LENGTH_LONG);
                    mensaje1.show();

                    //Intent intent = new Intent(v.getContext(), juegoGrafico(nivel).class);
                    //startActivityForResult(intent, 0);

                }
            });

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();

                    //Intent intent = new Intent(v.getContext(), juegoGrafico(nivel).class);
                    //startActivityForResult(intent, 0);

                }
            });

        }else{

            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"son iguales :)",Toast.LENGTH_LONG);
                    mensaje1.show();

                    //Intent intent = new Intent(v.getContext(), juegoGrafico(nivel).class);
                    //startActivityForResult(intent, 0);

                }
            });

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"son iguales :)",Toast.LENGTH_LONG);
                    mensaje1.show();

                    //Intent intent = new Intent(v.getContext(), juegoGrafico(nivel).class);
                    //startActivityForResult(intent, 0);

                }
            });

        }

    }
}