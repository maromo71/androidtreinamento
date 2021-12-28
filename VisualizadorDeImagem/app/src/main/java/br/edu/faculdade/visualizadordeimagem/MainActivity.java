package br.edu.faculdade.visualizadordeimagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgFoto;
    Button btnFoto;
    TextView txtInformacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgFoto = findViewById(R.id.imgFoto);
        btnFoto = findViewById(R.id.btnFoto);
        txtInformacao = findViewById(R.id.txtInformacao);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int num = r.nextInt(3);
                if(num==0){
                    imgFoto.setImageResource(R.drawable.foto1);
                    txtInformacao.setText("Foto 1");
                    return;
                }
                if(num==1){
                    imgFoto.setImageResource(R.drawable.foto2);
                    txtInformacao.setText("Foto 2");
                    return;
                }
                if(num==2){
                    imgFoto.setImageResource(R.drawable.foto3);
                    txtInformacao.setText("Foto 3");
                    return;
                }
            }
        });
    }
}