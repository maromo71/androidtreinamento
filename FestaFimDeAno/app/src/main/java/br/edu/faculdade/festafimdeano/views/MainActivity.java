package br.edu.faculdade.festafimdeano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.edu.faculdade.festafimdeano.R;
import br.edu.faculdade.festafimdeano.constants.FimDeAnoConstants;
import br.edu.faculdade.festafimdeano.util.SecurityPreferences;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat("dd/MM/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDayLeft = findViewById(R.id.text_day_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);
        this.mSecurityPreferences = new SecurityPreferences(this);
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeftToEndOfYear()),
                getString(R.string.dias));
        this.mViewHolder.textDayLeft.setText(daysLeft);



    }

    private int getDaysLeftToEndOfYear() {
        // Incializa instância do calendário e obtém o dia do ano
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        // Pega o dia máximo do ano - De 1 até 365. Podem existir anos bissextos.
        Calendar calendarLastDay = Calendar.getInstance();
        int dayDecember31 = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        // Calcula quantidade de dias restantes pro fim do ano
        return dayDecember31 - today;
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_confirm) {

            String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE);

            // Lógica de navegação
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
            intent.putExtra("presence_key", presence);
        }


    }





    private void verifyPresence() {
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE);
        if (presence.equals(""))
            this.mViewHolder.buttonConfirm.setText(R.string.nao_confirmado);
        else if (presence.equals(FimDeAnoConstants.CONFIRMATION_YES))
            this.mViewHolder.buttonConfirm.setText(R.string.sim);
        else
            this.mViewHolder.buttonConfirm.setText(R.string.nao);
    }



    private static class ViewHolder {
        TextView textToday;
        TextView textDayLeft;
        Button buttonConfirm;
    }






}
