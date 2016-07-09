package org.clickpositivo.memotest.recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.clickpositivo.memotest.entities.Puntaje;
import org.clickpositivo.memotest.R;

import java.util.ArrayList;

/**
 * Created by Marcelo on 13/6/2016.
 */
public class MyAdapterPuntajes extends RecyclerView.Adapter<MyViewHolderPuntajes> {

    ArrayList<Puntaje> p;

    public MyAdapterPuntajes(ArrayList<Puntaje> p){
        this.p=p;
    }


    @Override
    public MyViewHolderPuntajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_puntajes, parent, false);
        MyViewHolderPuntajes mvhp = new MyViewHolderPuntajes(v);
        return mvhp;
    }

    @Override
    public void onBindViewHolder(MyViewHolderPuntajes holder, int position) {
        Puntaje a = p.get(position);
        MyViewHolderPuntajes mvhp = holder;
        int lugar = position++;
        mvhp.position = lugar;
        mvhp.puesto.setText(Integer.toString(position));
        mvhp.nombre.setText(a.getNombre());
        mvhp.tiempo.setText(a.getTiempo());
    }

    @Override
    public int getItemCount() {
        return p.size();
    }
}
