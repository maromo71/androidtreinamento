package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SaudacaoActivity extends AppCompatActivity {
    private TextView txt_saudacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saudacao);

        txt_saudacao = findViewById(R.id.txt_saudacao);
        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");
        String email = args.getString("email");
        txt_saudacao.setText("Bem-vindo " + nome + ", seu email é: " + email);
    }
}