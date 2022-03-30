package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edt_name;
    private EditText edt_email;
    private Button btn_acesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        btn_acesso = findViewById(R.id.btn_acesso);

        btn_acesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SaudacaoActivity.class);
                Bundle params = new Bundle();
                params.putString("nome", edt_name.getText().toString());
                params.putString("email", edt_email.getText().toString());
                intent.putExtras(params);
                startActivity(intent); //abrir a Activity Saudacao
            }
        });


    }
}