package br.edu.faculdade.velhaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons = new Button[9];
    private int numJogadas = 0;
    private String[] matriz = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtons();
    }

    public void initializeButtons(){
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);
        buttons[4] = findViewById(R.id.btn5);
        buttons[5] = findViewById(R.id.btn6);
        buttons[6] = findViewById(R.id.btn7);
        buttons[7] = findViewById(R.id.btn8);
        buttons[8] = findViewById(R.id.btn9);
    }

    public void onClickButtons(){
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jogar(finalI);
                }
            });
            matriz[i] = "";
        }
    }
    private void jogar(int i){
        if(matriz[i].equals("")){
            if (numJogadas % 2 == 1){
                matriz[i] = "X";
            }else{
                matriz[i] = "0";
            }
            numJogadas++;
            exibirBotoes();
        }else{
            AlertDialog.Builder cxDialogo = new AlertDialog.Builder(this);
            cxDialogo.setNeutralButton("OK", null);
            cxDialogo.setTitle("Erro");
            cxDialogo.setMessage("Casa já jogada, escolha outra");
            return;
        }
    }

    private void exibirBotoes() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(matriz[i]);
        }
    }

    private void verificarVencedor(){
        if (numJogadas > 0 && numJogadas <9){
            //Jogador X
            if(matriz[0].equals("X") && matriz[1].equals("X") && matriz[2].equals("X")) {
                venceu("X");
            }
            if(matriz[3].equals("X") && matriz[4].equals("X") && matriz[5].equals("X")) {
                venceu("X");
            }
            if(matriz[6].equals("X") && matriz[7].equals("X") && matriz[8].equals("X")) {
                venceu("X");
            }
            if(matriz[0].equals("X") && matriz[3].equals("X") && matriz[6].equals("X")) {
                venceu("X");
            }
            if(matriz[1].equals("X") && matriz[4].equals("X") && matriz[7].equals("X")) {
                venceu("X");
            }
            if(matriz[2].equals("X") && matriz[5].equals("X") && matriz[8].equals("X")) {
                venceu("X");
            }
            if(matriz[0].equals("X") && matriz[4].equals("X") && matriz[8].equals("X")) {
                venceu("X");
            }
            if(matriz[2].equals("X") && matriz[4].equals("X") && matriz[5].equals("X")) {
                venceu("X");
            }
            //Jogador 0
            if(matriz[0].equals("0") && matriz[1].equals("0") && matriz[2].equals("0")) {
                venceu("0");
            }
            if(matriz[3].equals("0") && matriz[4].equals("0") && matriz[5].equals("0")) {
                venceu("0");
            }
            if(matriz[6].equals("0") && matriz[7].equals("0") && matriz[8].equals("0")) {
                venceu("0");
            }
            if(matriz[0].equals("0") && matriz[3].equals("0") && matriz[6].equals("0")) {
                venceu("0");
            }
            if(matriz[1].equals("0") && matriz[4].equals("0") && matriz[7].equals("0")) {
                venceu("0");
            }
            if(matriz[2].equals("0") && matriz[5].equals("0") && matriz[8].equals("0")) {
                venceu("0");
            }
            if(matriz[0].equals("0") && matriz[4].equals("0") && matriz[8].equals("0")) {
                venceu("0");
            }
            if(matriz[2].equals("0") && matriz[4].equals("0") && matriz[5].equals("0")) {
                venceu("0");
            }
        }
    }

    private void venceu(String jogador) {
        AlertDialog.Builder cxDialogo = new AlertDialog.Builder(this);
        cxDialogo.setNeutralButton("OK", null);
        cxDialogo.setTitle("Vencedor");
        cxDialogo.setMessage("Jogador " + jogador + " venceu a partida");
        limparTabuleiro();
        numJogadas = 0;
    }

    private void limparTabuleiro() {
        for (int i = 0; i < 9; i++) {
            matriz[i] = "";
        }
        exibirBotoes();
    }
}