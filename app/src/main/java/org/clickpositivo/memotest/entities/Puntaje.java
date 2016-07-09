package org.clickpositivo.memotest.entities;

/**
 * Created by Marcelo on 12/6/2016.
 */

public class Puntaje {

        private int id;
        private String nombre;
        private String tiempo;
        private String memoTest;


        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getTiempo() {
            return tiempo;
        }
        public void setTiempo(String tiempo) {
            this.tiempo = tiempo;
        }

    public String getMemoTest() {
        return memoTest;
    }

    public void setMemoTest(String memoTest) {
        this.memoTest = memoTest;
    }
}
