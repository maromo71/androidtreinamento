package br.edu.faculdade.listadecontatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listaContatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatos = findViewById(R.id.listaContatos);

        listaContatos.setOnItemClickListener((adapterView, view, i, l) -> {
            String nome = ((TextView) view).getText().toString();
            AlertDialog.Builder cx = new AlertDialog.Builder(MainActivity.this);
            cx.setTitle("Contato Selecionado");
            cx.setMessage("Contato: " + nome);
            cx.setNeutralButton("OK", null);
            cx.show();
        });
    }
}