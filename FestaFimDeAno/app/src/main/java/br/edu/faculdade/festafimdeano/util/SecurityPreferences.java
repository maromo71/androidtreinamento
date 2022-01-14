package br.edu.faculdade.festafimdeano.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    private final SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("FimDeAno", Context.MODE_PRIVATE);
        //Nota: "FimDeAno" será o arquivo que usaremos
        //É a chave do SharedPreferences
    }

    public void storeString(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key){
        return this.mSharedPreferences.getString(key, "");
    }

}
