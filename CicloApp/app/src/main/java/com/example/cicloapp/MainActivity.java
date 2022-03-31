package com.example.cicloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String momento;
    public static int contador = 0;
    public TextView txt_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        momento = "Passei pelo Created";
        contador++;
        txt_texto = findViewById(R.id.txt_texto);

        txt_texto.setText("Momento: " + momento +
                " Cont: " + contador);

        System.out.println("M: " + momento + "C: " + contador);

    }

    @Override
    protected void onStart() {
        super.onStart();
        momento = "Passei pelo Started";
        contador++;
        txt_texto = findViewById(R.id.txt_texto);
        txt_texto.setText("Momento: " + momento +
                " Cont: " + contador);
        System.out.println("M: " + momento + "C: " + contador);
    }

    @Override
    protected void onResume() {
        super.onResume();
        momento = "Passei pelo Resumido";
        contador++;
        txt_texto = findViewById(R.id.txt_texto);
        txt_texto.setText("Momento: " + momento +
                " Cont: " + contador);
        System.out.println("M: " + momento + "C: " + contador);
    }

    @Override
    protected void onPause() {
        super.onPause();
        momento = "Passei pelo Pausado";
        contador++;
        txt_texto = findViewById(R.id.txt_texto);
        txt_texto.setText("Momento: " + momento +
                " Cont: " + contador);
        System.out.println("M: " + momento + "C: " + contador);
    }

    @Override
    protected void onStop() {
        super.onStop();
        momento = "Passei pelo Parado";
        contador++;
        txt_texto = findViewById(R.id.txt_texto);
        txt_texto.setText("Momento: " + momento +
                " Cont: " + contador);
        System.out.println("M: " + momento + "C: " + contador);
    }
}