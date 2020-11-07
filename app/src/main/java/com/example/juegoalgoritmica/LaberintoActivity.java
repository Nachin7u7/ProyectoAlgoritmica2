package com.example.juegoalgoritmica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LaberintoActivity extends AppCompatActivity {
    public static String LOG = LaberintoActivity.class.getName();
    private Button siSePuede;
    private Button noSePuede;
    static boolean[][] laberinto;
    static int xFinal;
    static int yFinal;
    boolean sePuedeResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();

    }
    private void initViews(){
        ImageView imagen = findViewById(R.id.laberintoImagen);
        siSePuede = findViewById(R.id.laberintoSi1);
        noSePuede = findViewById(R.id.laberintoNo1);
        iniciarLaberinto();
        sePuedeResolver=resolverLaberinto(0,9);
        if(sePuedeResolver) imagen.setImageResource(R.drawable.laberinto1);
        else    imagen.setImageResource(R.drawable.laberinto2);
    }
    private void addEvents(){
        siSePuede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sePuedeResolver){
                    Toast.makeText(LaberintoActivity.this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LaberintoActivity.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
        noSePuede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sePuedeResolver){
                    Toast.makeText(LaberintoActivity.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LaberintoActivity.this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void iniciarLaberinto(){
        int aux = (int)(Math.random()*(2));
        boolean auxiliar = aux  == 1;
        boolean[] fila1= {true,true,true,true,true,true,false,true,true,true,true,true,true,true,true};
        boolean[] fila2= {true,false,false,false,false,false,false,true,false,false,false,false,true,false,true};
        boolean[] fila3= {true,false,true,true,true,true,false,true,true,true,true,false,true,false,true};
        boolean[] fila4= {true,false,true,false,false,false,false,false,false,false,true,false,true,false,true};
        boolean[] fila5= {true,false,true,true,true,true,true,true,true,true,true,false,true,false,true};
        boolean[] fila6= {true,false,false,false,false,false,false,false,false,false,true,false,true,false,true};
        boolean[] fila7= {true,true,true,true,true,true,true,true,true,false,true,false,true,false,true};
        boolean[] fila8= {false,true,false,false,true,false,false,false,false,false,true,true,true,false,true};
        boolean[] fila9= {false,false,false,false,true,false,true,true,  auxiliar ,true,true,true,true,false,true}; //aqui jaja
        boolean[] fila10= {true,true,true,false,true,false,true,false,false,false,false,false,true,false,true};
        boolean[] fila11= {false,false,true,false,true,false,true,false,true,true,true,false,true,false,true};
        boolean[] fila12= {true,true,true,false,true,false,true,false,true,false,false,false,true,false,true};
        boolean[] fila13= {true,false,true,true,true,false,true,false,true,false,true,true,true,false,true};
        boolean[] fila14= {true,false,true,false,false,false,true,false,true,false,false,false,false,false,true};
        boolean[] fila15= {true,false,true,true,true,true,true,false,true,true,true,true,true,true,true};
        laberinto=new boolean[15][15];
        laberinto[0]=fila1;
        laberinto[1]=fila2;
        laberinto[2]=fila3;
        laberinto[3]=fila4;
        laberinto[4]=fila5;
        laberinto[5]=fila6;
        laberinto[6]=fila7;
        laberinto[7]=fila8;
        laberinto[8]=fila9;
        laberinto[9]=fila10;
        laberinto[10]=fila11;
        laberinto[11]=fila12;
        laberinto[12]=fila13;
        laberinto[13]=fila14;
        laberinto[14]=fila15;
        xFinal=14;
        yFinal=9;
    }
    public static boolean resolverLaberinto(int x, int y) {
        if(x==xFinal&&y==yFinal) {
            return true;
        }
        else {
            laberinto[y][x]=false;
            if(x>0&&laberinto[y][x-1]&&resolverLaberinto(x-1,y)) {
                return true;
            }else if(x<laberinto.length-1&&laberinto[y][x+1]&&resolverLaberinto(x+1,y)) {
                return true;
            }else if(y>0&&laberinto[y-1][x]&&resolverLaberinto(x,y-1)) {
                return true;
            }else if(y<laberinto[0].length-1&&laberinto[y+1][x]&&resolverLaberinto(x,y+1)) {
                return true;
            }
            laberinto[y][x]=true;
        }
        return false;
    }
}
