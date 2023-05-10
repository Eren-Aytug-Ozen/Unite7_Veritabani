package com.example.unite7.Uyg3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class UrunAdapter extends ArrayAdapter<Urun> {
    ArrayList<Urun> urunler;
    Context context;

    public UrunAdapter(@NonNull Context context, ArrayList<Urun> urunler) {
        super(context, 0, urunler);
        this.context = context;
        this.urunler = urunler;
    }

    @Override
    public int getCount() {
        return urunler.size();
    }

    @Override
    public Urun getItem(int i) {
        return urunler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return urunler.get(i).hashCode();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

    }

}
