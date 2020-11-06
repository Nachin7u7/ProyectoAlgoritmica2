package com.example.juegoalgoritmica;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class PalabrasActivity extends AppCompatActivity {
    public static String LOG = PalabrasActivity.class.getName();
    private ImageView bPalabrasCheck;
    private EditText numeroIngresado;
    static int tamanoAfabeto = 26;
    int respuesta;

    static class Nodo {
        Map<Character, Nodo> hijos;
        boolean FinDePalabra;
        int palabrasComoBase;
        Nodo() {
            palabrasComoBase=0;
            FinDePalabra = false;
            hijos = new HashMap<Character, Nodo>();
        }
        public void aumentarPalabras() {
            palabrasComoBase++;
        }
    }

    static Nodo raiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();
    }
    private void initViews(){
        bPalabrasCheck = findViewById(R.id.palabrascheck);
        numeroIngresado = findViewById(R.id.numeroPalabarasUsuario);
        raiz = new Nodo();
        agregarPalabrasImagen();
        respuesta=contarPalabras("pr");
    }


    private void addEvents() {
        bPalabrasCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero=numeroIngresado.getText().toString();
                if (!numero.isEmpty()){
                    if(respuesta==Integer.parseInt(numero)){
                        Toast.makeText(PalabrasActivity.this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PalabrasActivity.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(PalabrasActivity.this, "Ingrese un número", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void agregarPalabrasImagen() {
        agregarPalabra("prision");
        agregarPalabra("portada");
        agregarPalabra("protesta");
        agregarPalabra("aprender");
        agregarPalabra("primate");
        agregarPalabra("persecucion");
        agregarPalabra("apretar");
        agregarPalabra("prenda");
        agregarPalabra("apartar");
        agregarPalabra("prisma");
        agregarPalabra("acertijo");
        agregarPalabra("paralelepipedo");
        agregarPalabra("pintar");
        agregarPalabra("oprimir");
        agregarPalabra("primero");
        agregarPalabra("portero");

    }
    static void agregarPalabra(String palabra) {
        Nodo nodoActual = raiz;
        int letras = palabra.length();
        for (int i = 0; i < letras; i++) {
            if (nodoActual.hijos.containsKey(palabra.charAt(i))) {
                nodoActual.hijos.get(palabra.charAt(i)).aumentarPalabras();
                nodoActual = nodoActual.hijos.get(palabra.charAt(i));
            } else {
                nodoActual.hijos.put(palabra.charAt(i), new Nodo());
                nodoActual.hijos.get(palabra.charAt(i)).aumentarPalabras();;
                nodoActual = nodoActual.hijos.get(palabra.charAt(i));
            }
        }
        nodoActual.FinDePalabra = true;
    }

    static int contarPalabras(String palabra) {
        Nodo nodoActual = raiz;
        int letras = palabra.length();
        for (int i = 0; i < letras; i++) {
            if (nodoActual.hijos.containsKey(palabra.charAt(i))) {
                nodoActual = nodoActual.hijos.get(palabra.charAt(i));
            } else {
                return 0;
            }
        }
        return nodoActual.palabrasComoBase;
    }
}
