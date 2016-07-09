package org.clickpositivo.memotest.recyclers;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.clickpositivo.memotest.entities.Ficha;
import org.clickpositivo.memotest.mainActivity.OnFichaClick;
import org.clickpositivo.memotest.R;

import java.util.List;

public class MyAdapter extends Adapter<MyViewHolder> {

    private List<Ficha> lista;

    private OnFichaClick listener;

    public MyAdapter(List<Ficha> lista, OnFichaClick listener)
    {
        this.lista=lista;
        this.listener=listener;
        // recibir el objeto listener para pasarselo al viewholder
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v, listener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Ficha a = lista.get(position);
        MyViewHolder mvh = holder;

        mvh.position = position;

        if(a.getEstado()) {
            mvh.img.setImageResource(R.drawable.question_icon);
        }else {
            mvh.img.setImageResource(a.getImagen());
        }
        // cargar el viewholder con la info del objeto Ficha : si esta destapado, cargo el imageview con la imagen de la ficha
        // si esta tapada, cargo el imageview con la imagen del signo de pregunta

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
