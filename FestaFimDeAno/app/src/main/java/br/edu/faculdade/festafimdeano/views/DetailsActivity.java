package br.edu.faculdade.festafimdeano.views;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import br.edu.faculdade.festafimdeano.R;
import br.edu.faculdade.festafimdeano.constants.FimDeAnoConstants;
import br.edu.faculdade.festafimdeano.util.SecurityPreferences;


public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.loadDataFromActivity();


    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(FimDeAnoConstants.PRESENCE);
            if (presence != null) {
                this.mViewHolder.checkParticipate.setChecked(true);
            } else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {
                //Salvar a presença
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE,
                        FimDeAnoConstants.CONFIRMATION_YES);
            } else {
                //Salvar a ausencia
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE,
                        FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    public static class ViewHolder {
        CheckBox checkParticipate;
    }

}