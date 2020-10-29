package com.example.juegoalgoritmica;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecuenciaActivity  extends AppCompatActivity {
    public static String LOG = SecuenciaActivity.class.getName();
    private Button bsecuencia1;
    private Button bsecuencia2;
    private Button bsecuencia3;
    private Button bsecuencia4;
    private Button bsecuencia5;
    private Button bsecuencia6;
    private ImageView bsecuenciaCheck;
    int[] arreglo;
    int respuesta;
    int seleccion;
    int logrados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secuencia);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();
    }
    private void initViews(){
        bsecuencia1 = findViewById(R.id.secuencia1);
        bsecuencia2 = findViewById(R.id.secuencia2);
        bsecuencia3 = findViewById(R.id.secuencia3);
        bsecuencia4 = findViewById(R.id.secuencia4);
        bsecuencia5 = findViewById(R.id.secuencia5);
        bsecuencia6 = findViewById(R.id.secuencia6);
        bsecuenciaCheck = findViewById(R.id.secuenciacheck);
        logrados=0;
        seleccion=0;
        arregloEnPantalla();
    }

    private void addEvents(){
        bsecuencia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitarSeleccion();
                seleccion=1;
                bsecuencia1.setBackgroundColor(Color.parseColor("#FF5722"));

            }
        });
        bsecuencia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitarSeleccion();
                seleccion=2;
                bsecuencia2.setBackgroundColor(Color.parseColor("#FF5722"));

            }
        });
        bsecuencia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitarSeleccion();
                seleccion=3;
                bsecuencia3.setBackgroundColor(Color.parseColor("#FF5722"));

            }
        });
        bsecuencia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitarSeleccion();
                seleccion=4;
                bsecuencia4.setBackgroundColor(Color.parseColor("#FF5722"));

            }
        });
        bsecuencia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitarSeleccion();
                seleccion=5;
                bsecuencia5.setBackgroundColor(Color.parseColor("#FF5722"));

            }
        });
        bsecuencia6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitarSeleccion();
                seleccion=6;
                bsecuencia6.setBackgroundColor(Color.parseColor("#FF5722"));

            }
        });
        bsecuenciaCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seleccion==0){
                    Toast.makeText(SecuenciaActivity.this, "Selecciona una", Toast.LENGTH_SHORT).show();
                }
                else if(arreglo[seleccion-1]==respuesta){
                    logrados++;
                    if(logrados<5) {
                        Toast.makeText(SecuenciaActivity.this, "Bien hecho, te faltan: " + (5 - logrados), Toast.LENGTH_SHORT).show();
                        quitarSeleccion();
                        arregloEnPantalla();
                    }else{
                        Toast.makeText(SecuenciaActivity.this, "Lo lograste", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    quitarSeleccion();
                    arregloEnPantalla();
                    logrados=0;
                    Toast.makeText(SecuenciaActivity.this,"Intentalo de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //Código de las secuencias
    void secuencia1() {
        int n = (int) (Math.random() * 4 + 1)+2;
        int p = (int) (Math.random() * 9 + 1);

        arreglo[0] = p;
        for (int i = 1; i < arreglo.length - 1; i++) {
            arreglo[i] = p * n - 1;
            p = p * n - 1;
        }
    }

    void secuencia2() {
        int n = (int) (Math.random() * 9 + 2);
        int p = (int) (Math.random() * 9 + 1);

        arreglo[0] = p;
        for (int i = 1; i < arreglo.length - 1; i++) {
            arreglo[i] = p + n;
            p = p + n;
        }
    }

    void secuencia3() {
        int n = (int) (Math.random() * 9 + 1);
        int p = (int) (Math.random() * 9 + 1);

        arreglo[0] = p;
        for (int i = 1; i < arreglo.length - 1; i++) {
            arreglo[i] = p + n;
            p = p + n;
            n++;
        }
    }

    void secuencia4() {
        int n = (int) (Math.random() * 4 + 1)+1;
        int p = (int) (Math.random() * 9 + 1);

        arreglo[0] = p;
        for (int i = 1; i < arreglo.length - 1; i++) {
            arreglo[i] = p * n;
            p = p * n;

        }
    }

    void secuencia5() {
        int p = (int) (Math.random() * 5 + 1);
        System.out.println(p+" n");
        arreglo[0] = p*p-1;
        p++;
        for (int i = 1; i < arreglo.length - 1; i++) {
            arreglo[i] = p * p-1;
            p++;
        }
    }
    //Agregar numero aleatorio mediante busqueda binaria
    void agregarExtra() {
        int aleatorio = (int) (Math.random() * (arreglo[arreglo.length - 2]*2+5-arreglo[0]+1) + arreglo[0]);
        respuesta=aleatorio;
        // int posicion = (int)(Math.random()*(arreglo.length));
        int izquierda = 0;
        int derecha = arreglo.length - 2;
        int guardaPosicion = 0;
        boolean valorExistente = false;
        while (izquierda <= derecha && !valorExistente) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arreglo[medio] == aleatorio) {
                valorExistente = true;
            }
            if (arreglo[medio] < aleatorio) {
                guardaPosicion = medio;
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        if (valorExistente) {
            agregarExtra();
        } else {
            int aux = arreglo[guardaPosicion+1];
            arreglo[guardaPosicion+1]=aleatorio;
            for (int i = guardaPosicion+2; i < arreglo.length; i++) {
                int aux2=arreglo[i];
                arreglo[i]=aux;
                aux=aux2;
            }
        }
    }
    //Escoge una secuencia y muestra sus valores
    void arregloEnPantalla(){
        arreglo=new int[6];
        int secuencia = (int) (Math.random() * 5 + 1);
        if(secuencia==1) {
            secuencia1();
        }else if(secuencia==2) {
            secuencia2();
        }else if(secuencia==3) {
            secuencia3();
        }else if(secuencia==4) {
            secuencia4();
        }else if(secuencia==5) {
            secuencia5();
        }
        agregarExtra();
        bsecuencia1.setText(""+arreglo[0]);
        bsecuencia2.setText(""+arreglo[1]);
        bsecuencia3.setText(""+arreglo[2]);
        bsecuencia4.setText(""+arreglo[3]);
        bsecuencia5.setText(""+arreglo[4]);
        bsecuencia6.setText(""+arreglo[5]);
    }
    //Quita la seleccion
    void quitarSeleccion(){
        seleccion=0;
        bsecuencia1.setBackgroundColor(Color.parseColor("#FFA000"));
        bsecuencia2.setBackgroundColor(Color.parseColor("#FFA000"));
        bsecuencia3.setBackgroundColor(Color.parseColor("#FFA000"));
        bsecuencia4.setBackgroundColor(Color.parseColor("#FFA000"));
        bsecuencia5.setBackgroundColor(Color.parseColor("#FFA000"));
        bsecuencia6.setBackgroundColor(Color.parseColor("#FFA000"));

    }
}
