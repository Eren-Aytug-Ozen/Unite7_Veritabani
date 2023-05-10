package com.example.unite7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Uyg1 extends AppCompatActivity {

   EditText txtKulAdi;
   Button btnKaydet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyg1);
        txtKulAdi.findViewById(R.id.txtKulAdi);
        SharedPreferences sharedPreferences=this.getPreferences(Context.MODE_PRIVATE);
        String gelenveri=sharedPreferences.getString("kullanici","");
        if(!gelenveri.isEmpty()){
            txtKulAdi.setText(gelenveri);
        }
    }
    public void btnKaydet(View view){
        String veri;
        veri = txtKulAdi.getText().toString();
        SharedPreferences sharedPreferences=this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("kullanici",veri);
        editor.apply();
    }
}
