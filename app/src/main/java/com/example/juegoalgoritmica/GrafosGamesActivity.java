package com.example.juegoalgoritmica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class GrafosGamesActivity extends AppCompatActivity {

    private Button botonan1;
    private Button botonan2;
    private Button botonan3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafos_games);
        int nodos = 6;
        int conecciones = 9;

        ArrayList<Arista>[] grafo = new ArrayList[nodos];

        for(int i = 0; i < nodos; i++) {
            grafo[i] = new ArrayList<>();
        }


        grafo[0].add(new Arista(1, 7));
        grafo[0].add(new Arista(2, 9));
        grafo[0].add(new Arista(5, 14));
        grafo[1].add(new Arista(3, 15));
        grafo[2].add(new Arista(5, 2));
        grafo[2].add(new Arista(3, 11));
        grafo[5].add(new Arista(4, 9));
        grafo[3].add(new Arista(4, 6));
        grafo[1].add(new Arista(2, 10));

        int consultas = 1;

        int result=0;
        for (int i = 0; i < consultas; i++ ) {
            int inicio = 0;
            int fin = 4;

            result = dijkstra(grafo, inicio, fin);
        }

        botonan1 = findViewById(R.id.an1);
        botonan2 = findViewById(R.id.an2);
        botonan3 = findViewById(R.id.an3);
        botonan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Incorrecto!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        int finalResult = result;
        botonan2.setText(finalResult +" Metros");
        botonan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Correcto!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        botonan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Incorrecto!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    static final int oo = Integer.MAX_VALUE;
    static class Arista implements Comparable<Arista>{
        int nodo;
        int peso;
        Arista(int nodo, int peso) {
            this.nodo = nodo;
            this.peso = peso;
        }
        public int compareTo(Arista o) {
            return this.peso - o.peso;
        }
    }


    static int dijkstra(ArrayList<Arista>[] grafo, int inicio, int fin) {
        PriorityQueue<Arista> pq = new PriorityQueue<>();
        int[] dist = new int[grafo.length];
        Arrays.fill(dist, oo);
        dist[inicio] = 0;
        pq.add(new Arista(inicio, 0));

        while(!pq.isEmpty()) {
            Arista actual = pq.remove();
            for(int i = 0; i < grafo[actual.nodo].size(); i++) {
                Arista vecino = grafo[actual.nodo].get(i);
                //relajacion
                if(dist[vecino.nodo] > (dist[actual.nodo] + vecino.peso)) {
                    dist[vecino.nodo] = dist[actual.nodo] + vecino.peso;
                    pq.add(new Arista(vecino.nodo, dist[vecino.nodo]));
                }
            }
        }

        return dist[fin];
    }
}


