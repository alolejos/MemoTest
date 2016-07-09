package org.clickpositivo.memotest.baseDatos;

/**
 * Created by Marcelo on 12/6/2016.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import org.clickpositivo.memotest.entities.Puntaje;

import java.util.ArrayList;


public class PuntajeDAO {

    private SQLiteDatabase db;
    private SQLiteStatement statementSave;

    public PuntajeDAO(SQLiteDatabase db)
    {
        this.db=db;
        statementSave = db.compileStatement("INSERT INTO listado (nombre,tiempo,memoTest) VALUES(?,?,?)");
    }

    public Puntaje getPuntajeById(int id)
    {
        Cursor c;
        Puntaje p=null;
        c = db.rawQuery("SELECT _id,nombre,tiempo,memoTest FROM listado FROM listado WHERE _id=" +id,null);

        if(c.moveToFirst())
        {
            p = new Puntaje();
            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setTiempo(c.getString(2));
            p.setMemoTest(c.getString(3));
        }
        c.close();
        return p;
    }

    public long save(Puntaje p)
    {
        statementSave.clearBindings();
        statementSave.bindString(1, p.getNombre());
        statementSave.bindString(2, p.getTiempo());
        statementSave.bindString(3, p.getMemoTest());
        return statementSave.executeInsert();
    }

    public void update(Puntaje p)
    {
        ContentValues values = new ContentValues();

        values.put("nombre", p.getNombre());
        values.put("puntaje", p.getTiempo());
        values.put("puntaje", p.getMemoTest());

        db.update("puntaje", values, "_id=" + p.getId(), null);
    }

    public void delete(Puntaje p)
    {
        db.delete("puntaje", "_id=" + p.getId(), null);
    }

    public ArrayList<Puntaje> getAll(int test){

        ArrayList<Puntaje> lista = new ArrayList<>();

        Cursor c;

        Puntaje p=null;

        switch (test){
            case 1:
                c = db.rawQuery("SELECT _id,nombre,tiempo,memoTest FROM listado WHERE memoTest='Familia' ORDER BY tiempo LIMIT 10",null);
                break;
            case 2:
                c = db.rawQuery("SELECT _id,nombre,tiempo,memoTest FROM listado WHERE memoTest='Amigos' ORDER BY tiempo LIMIT 10",null);
                break;
            case 3:
                c = db.rawQuery("SELECT _id,nombre,tiempo,memoTest FROM listado WHERE memoTest='Wendy' ORDER BY tiempo LIMIT 10",null);
                break;
            case 4:
                c = db.rawQuery("SELECT _id,nombre,tiempo,memoTest FROM listado WHERE memoTest='Jane' ORDER BY tiempo LIMIT 10",null);
                break;
            default:
                c = db.rawQuery("SELECT _id,nombre,tiempo,memoTest FROM listado ORDER BY tiempo LIMIT 10",null);
                break;
        }


        if(c.moveToFirst())
        {
            do{
                p = new Puntaje();
                p.setId(c.getInt(0));
                p.setNombre(c.getString(1));
                p.setTiempo(c.getString(2));
                p.setMemoTest(c.getString(3));
                lista.add(p);
            }while (c.moveToNext());
        }
        c.close();

        return lista;

    }
}




