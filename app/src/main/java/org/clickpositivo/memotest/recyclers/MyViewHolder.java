package org.clickpositivo.memotest.recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import org.clickpositivo.memotest.mainActivity.OnFichaClick;
import org.clickpositivo.memotest.R;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img;
    int position;
    OnFichaClick listener;


    public MyViewHolder(View itemView, OnFichaClick listener) {  // recibir listener
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.icon);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.clickEnFicha(position);
    }
}
