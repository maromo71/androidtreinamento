package br.edu.faculdade.mvpsample;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements Contract.View {

    // criando objeto textView da Classe TextView
    private TextView textView;

    // criando objeto button da Classe Button
    private Button button;

    // criando objeto progressBar da classe ProgressBar
    private ProgressBar progressBar;

    // criando objeto presenter da Interface de Contrato Presenter
    Contract.Presenter presenter;


    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        // instanciando objeto presenter da Interface Presenter
        presenter = new Presenter((Contract.View) this, new Model());

        // operações para serem realizadas quando o usuário
        // clicar sobre o botão.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onButtonClick();
            }
        });


    }

    @Override
    //metodo para mostrar o curso
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    //metodo para ocultar o curso
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    //apresentar um curso aleatorio
    public void setString(String string) {
        textView.setText(string);
    }
}