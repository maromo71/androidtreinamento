package br.edu.faculdade.velhaapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button[] buttons = new Button[9];
    Button btnNewGame;
    String[] tabu = new String[9];
    int numJogada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
        onClickButtons();

    }

    private void initializeButtons(){
        buttons[0] =  findViewById(R.id.btn1);
        buttons[1] =  findViewById(R.id.btn2);
        buttons[2] =  findViewById(R.id.btn3);
        buttons[3] =  findViewById(R.id.btn4);
        buttons[4] =  findViewById(R.id.btn5);
        buttons[5] =  findViewById(R.id.btn6);
        buttons[6] =  findViewById(R.id.btn7);
        buttons[7] =  findViewById(R.id.btn8);
        buttons[8] =  findViewById(R.id.btn9);
        btnNewGame =  findViewById(R.id.btn_novo);

    }

    private void onClickButtons(){
        for (int i= 0; i<9;i++){
            final int finalI = i;
            buttons[finalI].setOnClickListener(v -> play(finalI));
            tabu[i]="";
        }
        btnNewGame.setOnClickListener(view -> {
            numJogada = 0;
            for (int i = 0; i < 9; i++) {
                tabu[i] = "";
            }
            onShowButtons();
        });

    }

    private void play(int i) {
        if(!tabu[i].equals("")){
            AlertDialog.Builder cxDialogo = new AlertDialog.Builder(MainActivity.this);
            cxDialogo.setNeutralButton("OK", null);
            cxDialogo.setTitle("Erro");
            cxDialogo.setMessage("Casa já jogada, escolha outra");
            cxDialogo.show();
            return;
        }else{
            if(numJogada % 2 ==0){
                tabu[i] = "X";
            }else{
                tabu[i] = "0";
            }
            numJogada++;
            System.out.println("Teste");
            onShowButtons();
            verifyWinner();
        }
    }

    private void verifyWinner() {
        if (numJogada > 0 && numJogada <9){
            //Jogador X
            if(tabu[0].equals("X") && tabu[1].equals("X") && tabu[2].equals("X")) {
                winner("X");
            }
            if(tabu[3].equals("X") && tabu[4].equals("X") && tabu[5].equals("X")) {
                winner("X");
            }
            if(tabu[6].equals("X") && tabu[7].equals("X") && tabu[8].equals("X")) {
                winner("X");
            }
            if(tabu[0].equals("X") && tabu[3].equals("X") && tabu[6].equals("X")) {
                winner("X");
            }
            if(tabu[1].equals("X") && tabu[4].equals("X") && tabu[7].equals("X")) {
                winner("X");
            }
            if(tabu[2].equals("X") && tabu[5].equals("X") && tabu[8].equals("X")) {
                winner("X");
            }
            if(tabu[0].equals("X") && tabu[4].equals("X") && tabu[8].equals("X")) {
                winner("X");
            }
            if(tabu[2].equals("X") && tabu[4].equals("X") && tabu[6].equals("X")) {
                winner("X");
            }
            //Jogador 0
            if(tabu[0].equals("0") && tabu[1].equals("0") && tabu[2].equals("0")) {
                winner("0");
            }
            if(tabu[3].equals("0") && tabu[4].equals("0") && tabu[5].equals("0")) {
                winner("0");
            }
            if(tabu[6].equals("0") && tabu[7].equals("0") && tabu[8].equals("0")) {
                winner("0");
            }
            if(tabu[0].equals("0") && tabu[3].equals("0") && tabu[6].equals("0")) {
                winner("0");
            }
            if(tabu[1].equals("0") && tabu[4].equals("0") && tabu[7].equals("0")) {
                winner("0");
            }
            if(tabu[2].equals("0") && tabu[5].equals("0") && tabu[8].equals("0")) {
                winner("0");
            }
            if(tabu[0].equals("0") && tabu[4].equals("0") && tabu[8].equals("0")) {
                winner("0");
            }
            if(tabu[2].equals("0") && tabu[4].equals("0") && tabu[6].equals("0")) {
                winner("0");
            }
        }else{
            AlertDialog.Builder cxDialogo = new AlertDialog.Builder(MainActivity.this);
            cxDialogo.setNeutralButton("OK", null);
            cxDialogo.setTitle("Sem Vendor");
            cxDialogo.setMessage("Não houve vencedor");
            cxDialogo.show();
        }
    }

    private void winner(String strWinner) {
        AlertDialog.Builder cxDialogo = new AlertDialog.Builder(this);
        cxDialogo.setNeutralButton("OK", null);
        cxDialogo.setTitle("Vencedor");
        cxDialogo.setMessage("Jogador " + strWinner + " foi o vencedor");
        cxDialogo.show();
    }

    private void onShowButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(tabu[i]);
        }
    }
}