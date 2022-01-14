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

    private SecurityPreferences mSecurityPreferences; //atributo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mSecurityPreferences = new SecurityPreferences(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.check_participate){
            if(this.mViewHolder.checkParticipate.isChecked()){
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE,
                        FimDeAnoConstants.CONFIRMED_WILL_GO);
            }else{
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE,
                        FimDeAnoConstants.CONFIRMED_WONT_GO);
            }
        }
    }

    public static class ViewHolder {
        CheckBox checkParticipate;
    }

}