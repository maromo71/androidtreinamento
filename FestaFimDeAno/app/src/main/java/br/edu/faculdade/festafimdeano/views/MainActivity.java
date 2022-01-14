package br.edu.faculdade.festafimdeano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.faculdade.festafimdeano.R;
import br.edu.faculdade.festafimdeano.views.DetailsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id== R.id.button_confirm){
            //Lógica de Navegação
            //Passar o contexto da aplicação no primeiro parâmetro,
            //No segundo passar a activity que será aberta
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDayLeft = findViewById(R.id.text_day_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);
    }



    private static class ViewHolder {
        TextView textToday;
        TextView textDayLeft;
        Button buttonConfirm;
    }

}
