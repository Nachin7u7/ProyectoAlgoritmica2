package com.example.juegoalgoritmica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    public static String LOG = MenuActivity.class.getName();
    private Button botonJuego1;
    private Button botonJuego2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();
    }
    private void initViews(){
        botonJuego1 = findViewById(R.id.juego1);
        botonJuego2 = findViewById(R.id.juego2);
    }

    private void addEvents(){
        botonJuego1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secuenciaIntent = new Intent(MenuActivity.this, SecuenciaActivity.class);
                startActivity(secuenciaIntent);
            }
        });
        botonJuego2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent registerIntent = new Intent(InicioActivity.this, RegisterActivity.class);
                //startActivity(registerIntent);
            }
        });
    }
}