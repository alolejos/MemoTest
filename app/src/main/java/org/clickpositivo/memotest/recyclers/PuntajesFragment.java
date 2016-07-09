package org.clickpositivo.memotest.recyclers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.clickpositivo.memotest.entities.Puntaje;
import org.clickpositivo.memotest.baseDatos.MyOpenHelper;
import org.clickpositivo.memotest.baseDatos.PuntajeDAO;
import org.clickpositivo.memotest.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PuntajesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PuntajesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public PuntajesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_puntajes, container, false);

        if(this.getTag().equals("PUNTAJE_FAMILIA")) getActivity().setTitle("Puntajes Familia");
        if(this.getTag().equals("PUNTAJE_AMIGOS")) getActivity().setTitle("Puntajes Amigos");
        if(this.getTag().equals("PUNTAJE_WENDY")) getActivity().setTitle("Puntajes Peter - Wendy");
        if(this.getTag().equals("PUNTAJE_JANE")) getActivity().setTitle("Puntajes Peter - Jane");

        MyOpenHelper helper = new MyOpenHelper(getContext(), "puntaje.db");

        SQLiteDatabase db = helper.getWritableDatabase();

        PuntajeDAO datos = new PuntajeDAO(db);

        ArrayList<Puntaje> listadoPuntajes = null;

        if(this.getTag().equals("PUNTAJE_FAMILIA")) listadoPuntajes = datos.getAll(1);
        if(this.getTag().equals("PUNTAJE_AMIGOS")) listadoPuntajes = datos.getAll(2);
        if(this.getTag().equals("PUNTAJE_WENDY")) listadoPuntajes = datos.getAll(3);
        if(this.getTag().equals("PUNTAJE_JANE")) listadoPuntajes = datos.getAll(4);

        RecyclerView listaPuntajes = (RecyclerView)view.findViewById(R.id.lista_puntajes);

        MyAdapterPuntajes adaptador = new MyAdapterPuntajes(listadoPuntajes);

        listaPuntajes.setAdapter(adaptador);

        listaPuntajes.setLayoutManager(new LinearLayoutManager(getContext()));

        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
