package com.example.unite7.Uyg3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unite7.R;

import java.util.ArrayList;

public class Uyg3 extends AppCompatActivity {

    Urun urun;
    ArrayList<Urun> urunler;
    ListView listeUrunler;
    UrunAdapter urunAdapter;

    Button btnKaydet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyg3);
// tanımlama yapılıyor
        urunler = new ArrayList<>();
        listeUrunler = findViewById(R.id.urunListe);
        urunAdapter = new UrunAdapter(Uyg3.this,urunler);
        btnKaydet = findViewById(R.id.btnKayitEkle);
        listeUrunler.setAdapter(urunAdapter);
//urunşer tablosundaki bütün veriler get ediliyor
        getAllUrunler();

        listeUrunler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(Uyg3.this,UrunDetay.class);
                i.putExtra("id", urunler.get(position).getId());
                startActivity(i);
            }
        });
    }

    public void btnYeniKayitEkleClick(View view){
        Intent i = new Intent(Uyg3.this,UrunKayit.class);
        i.putExtra("mod","ekle");
        startActivity(i);
    }


    private void getAllUrunler(){
        database = this.openOrCreateDatabase("Urun",MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("SELECT * FROM urunler",null);
        int kolonId = cursor.getColumnIndex("id");
        int kolonUrunAdi = cursor.getColumnIndex("urunadi");
        int kolonFiyat = cursor.getColumnIndex("fiyat");
        int kolonAdet = cursor.getColumnIndex("adet");

        while (cursor.moveToNext()){
            int id = cursor.getInt(kolonId);
            String urunAdi = cursor.getString(kolonUrunAdi);
            double fiyat = cursor.getDouble(kolonFiyat);
            long adet = cursor.getLong(kolonAdet);

            urun = new Urun(id, urunAdi, fiyat, adet, R.drawable.resim_yok);
        }
        cursor.close();
    }
}
