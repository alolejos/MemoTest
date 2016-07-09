package org.clickpositivo.memotest.recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.clickpositivo.memotest.R;

/**
 * Created by Marcelo on 13/6/2016.
 */
public class MyViewHolderPuntajes extends RecyclerView.ViewHolder {

    TextView puesto;
    TextView nombre;
    TextView tiempo;
    int position;

        public MyViewHolderPuntajes(View itemView) {
            super(itemView);
            puesto = (TextView)itemView.findViewById(R.id.puesto);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            tiempo = (TextView)itemView.findViewById(R.id.tiempo);
        }
}
