package org.clickpositivo.memotest.mainActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.clickpositivo.memotest.threads.Conteo;
import org.clickpositivo.memotest.entities.Ficha;
import org.clickpositivo.memotest.entities.Puntaje;
import org.clickpositivo.memotest.threads.Hilo;
import org.clickpositivo.memotest.recyclers.MyAdapter;
import org.clickpositivo.memotest.baseDatos.MyOpenHelper;
import org.clickpositivo.memotest.baseDatos.PuntajeDAO;
import org.clickpositivo.memotest.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BlankFragment extends Fragment implements OnFichaClick, Handler.Callback {

    List<Ficha> fichas;
    boolean flagNuevaPagina;
    MyAdapter adapter;
    int posicionAnterior = 0;
    private Hilo h;
    private Conteo tiempo;
    int posicionActual = 0;
    Handler handler = new Handler(this);
    boolean darVuelta = true;
    TextView t;
    int aciertos, pruebas = 0;
    int tipo = 0;

    public void setFichas(int tipo) {
        switch (tipo){
            case 1:
                if (fichas.isEmpty()){
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_1));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_6));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_6));
                    Collections.shuffle(fichas);
                }else {
                    fichas.clear();
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_6));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_6));
                    Collections.shuffle(fichas);
                }
                break;
            case 2:
                if (fichas.isEmpty()){
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_22));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_22));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_23));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_23));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_24));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_24));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_25));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_25));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_26));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_26));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_27));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_27));
                    Collections.shuffle(fichas);
                }else {
                    fichas.clear();
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_22));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_22));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_23));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_23));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_24));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_24));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_25));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_25));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_26));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_26));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_27));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_27));
                    Collections.shuffle(fichas);
                }
                break;
            case 3:
                if (fichas.isEmpty()){
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_10));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_10));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_11));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_11));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_12));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_12));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_13));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_13));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_14));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_14));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_15));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_15));
                    Collections.shuffle(fichas);
                }else {
                    fichas.clear();
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_10));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_10));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_11));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_11));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_12));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_12));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_13));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_13));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_14));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_14));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_15));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_15));
                    Collections.shuffle(fichas);
                }
                break;
            case 4:
                if (fichas.isEmpty()){
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_16));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_16));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_17));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_17));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_18));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_18));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_19));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_19));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_20));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_20));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_21));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_21));
                    Collections.shuffle(fichas);
                }else {
                    fichas.clear();
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_16));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_16));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_17));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_17));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_18));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_18));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_19));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_19));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_20));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_20));
                    fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_21));
                    fichas.add(new Ficha(Ficha.TAPADA, R.drawable.img_21));
                    Collections.shuffle(fichas);
                }
                break;
        }


    }

    public void actualizar(){
        adapter.notifyDataSetChanged();
    }

    public void reseteo(){
        posicionActual = 0;
        posicionAnterior = 0;
        aciertos = 0;
        pruebas = 0;
        flagNuevaPagina = false;
        darVuelta = true;
        tiempo.setReiniciado(true);
        setFichas(tipo);
        actualizar();
        t.setTextColor(Color.parseColor("#000000"));
        t.setText("00:00:00");
    }

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        Bundle args = getArguments();

        tipo = args.getInt("tipo", 0);

        switch (tipo){
            case 1:
                getActivity().setTitle("Familia");
                break;
            case 2:
                getActivity().setTitle("Amigos");
                break;
            case 3:
                getActivity().setTitle("Wendy");
                break;
            case 4:
                getActivity().setTitle("Jane");
                break;
        }



        flagNuevaPagina=false;

        fichas = new ArrayList<Ficha>();

        setFichas(tipo);

        RecyclerView list = (RecyclerView)view.findViewById(R.id.list);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);

        list.setLayoutManager(layoutManager);

        adapter = new MyAdapter(fichas,this);

        list.setAdapter(adapter);

        t = (TextView)view.findViewById(R.id.textView);

        return view;
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1==1){
            fichas.get(posicionActual).setEstado(true);
            fichas.get(posicionAnterior).setEstado(true);
            actualizar();
            darVuelta = true;

        }
        if(msg.arg1==2){
            t.setText(msg.obj.toString());
        }
        if(msg.arg1==3){
            t.setText("Tiempo: " + msg.obj.toString());
            t.setTextColor(Color.parseColor("#FF0000"));
            DialogoPuntaje d = new DialogoPuntaje();
            d.setArguments(this, msg.obj.toString());
            d.show(getFragmentManager(), "Titulo del Dialogo");
        }
        if(msg.arg1==4){
            t.setText("Tiempo: 00:00:00");
        }
        return false;
    }

    public void guardarResultado(String s, String t) {
        MyOpenHelper helper = new MyOpenHelper(getContext(), "puntaje.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        PuntajeDAO datos = new PuntajeDAO(db);
        Puntaje ingreso = new Puntaje();
        ingreso.setNombre(s);
        ingreso.setTiempo(t);
        switch (tipo){
            case 1:
                ingreso.setMemoTest("Familia");
                break;
            case 2:
                ingreso.setMemoTest("Amigos");
                break;
            case 3:
                ingreso.setMemoTest("Wendy");
                break;
            case 4:
                ingreso.setMemoTest("Jane");
                break;
        }
        datos.save(ingreso);
        ArrayList<Puntaje> listado = new ArrayList<>();
        listado = datos.getAll(6);
        for(Puntaje a: listado) Log.d("Base", "Nombre: "+a.getNombre()+" Puntaje: "+a.getTiempo()+" Test: "+a.getMemoTest());
    }

    @Override
    public void clickEnFicha(int position) {
        if (pruebas==0){
            tiempo = new Conteo(handler);
            tiempo.start();
        }
        Ficha f = fichas.get(position);
        if (f.getEstado() && darVuelta){
            if(flagNuevaPagina){
                pruebas++;
                posicionActual = position;
                flagNuevaPagina=false;
                darVuelta = false;
                fichas.get(position).setEstado(false);
                actualizar();
                if(fichas.get(posicionAnterior).getImagen() == fichas.get(position).getImagen()){
                    aciertos++;
                    darVuelta = true;
                    if(aciertos==6){
                        tiempo.setTerminado(true);
                    }
                }else{
                    h = new Hilo(handler, 500);
                    h.start();
                }
            }else{
                pruebas++;
                fichas.get(position).setEstado(false);
                flagNuevaPagina = true;
                posicionAnterior = position;
                actualizar();
            }
        }
    }

}
