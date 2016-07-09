package org.clickpositivo.memotest.mainActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import org.clickpositivo.memotest.R;

/**
 * Created by Marcelo on 13/6/2016.
 */

public class DialogoPuntaje extends AppCompatDialogFragment {

    EditText ed;
    Fragment fragment;
    String tiempo;

    public DialogoPuntaje(){

    }

    public void setArguments(Fragment fr, String tiempo){
        fragment = fr;
        this.tiempo = tiempo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.puntaje_guardar, null);
        //builder.setView(inflater.inflate(R.layout.puntaje_guardar, null));
        builder.setView(view);
        ed = (EditText)view.findViewById(R.id.nombre);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((BlankFragment) fragment).guardarResultado(ed.getText().toString(), tiempo);
            }
        });
        builder.setTitle("Puntaje");
        builder.setMessage("Ingrese su nombre");
        return builder.create();
    }
}




