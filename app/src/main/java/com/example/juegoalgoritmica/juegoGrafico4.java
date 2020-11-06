package com.example.juegoalgoritmica;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class juegoGrafico4 extends AppCompatActivity {

    class Point{

        double x,y;
        Point(){}

        Point(double a,double b) {
            x = a;
            y = b;
        }

        void setX(double newX){
            x = newX;
        }
        void setY(double newY){
            y = newY;
        }

    };

    double cross(Point V, Point U) {
        return V.x * U.y - V.y * U.x;
    }

    Point operatorMinus(Point a, Point b){
        return new Point(a.x - b.x, a.y-b.y);
    }

    double area( Point A,  Point B,  Point C) {
        return cross(operatorMinus(C, A),operatorMinus(B, A));
    }

    boolean isConvex(Point poligon[]){
        int nroPoints = poligon.length;
        int areasPositive =  0;
        int areasNegative = 0;
        for(int i = 0; i < nroPoints ;i++) {
            double areaPoints = area(poligon[i],poligon[(i+1)%nroPoints],poligon[(i+2)%nroPoints]);
            if(areaPoints>0) {
                areasPositive++;
            } else if(areaPoints<0) {
                areasNegative++;
            }
        }
        return (areasPositive == 0 || areasNegative == 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_grafico4);

        Button ans1 = (Button) findViewById(R.id.ans1);
        Button ans2 = (Button) findViewById(R.id.ans2);

        TextView puntos[] = new TextView[5];
        puntos[0]= (TextView) findViewById(R.id.pt1);
        puntos[1]= (TextView) findViewById(R.id.pt2);
        puntos[2]= (TextView) findViewById(R.id.pt3);
        puntos[3]= (TextView) findViewById(R.id.pt4);
        puntos[4]= (TextView) findViewById(R.id.pt5);

        Point poligon[] = new Point[5];

        for(int i = 0 ; i < 5 ; i++){
            double x = (int)(Math.random()*(9-0)+1);
            double y = (int)(Math.random()*(9-0)+1);
            poligon[i] = new Point(x, y);
            puntos[i].setText((int)(x)+", "+(int)(y));
        }

        ans1.setText("hondo");
        ans2.setText("plano");


        if(isConvex(poligon)){

            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico5.class);
                    startActivityForResult(intent, 0);

                }
            });

            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :(....",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico5.class);
                    startActivityForResult(intent, 0);

                }
            });

        }else{

            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"¡CORRECTO!",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico5.class);
                    startActivityForResult(intent, 0);

                }
            });

            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast mensaje1 =
                            Toast.makeText(getApplicationContext(),"incorrecto :(....",Toast.LENGTH_LONG);
                    mensaje1.show();

                    Intent intent = new Intent(v.getContext(), juegoGrafico5.class);
                    startActivityForResult(intent, 0);

                }
            });

        }

    }
}