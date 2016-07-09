package org.clickpositivo.memotest.threads;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Marcelo on 4/6/2016.
 */
public class Conteo extends Thread {

    boolean terminado = false;
    boolean reiniciado = false;
    int segundos=00;
    int centesimas=00;
    int minutos=0;
    String cron;
    Handler handler;
    String texto;
    String patron = "%02d:%02d:%02d";

    public Conteo(Handler handler)
    {
        this.handler=handler;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public void setReiniciado(boolean reiniciado) {
        this.reiniciado = reiniciado;
    }

    @Override
    public void run()
    {
        while(!terminado && !reiniciado)
        {
            try {
                this.sleep(10);
                centesimas++;
                if (centesimas==99){
                    centesimas=0;
                    segundos++;
                    if (segundos == 59) {
                        segundos = 0;
                        minutos++;
                    }
                }
                texto = String.format(patron, minutos, segundos, centesimas);
                Message m = new Message();
                m.arg1=2;
                m.obj = texto;
                handler.sendMessage(m);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (terminado){
            Message m = new Message();
            m.arg1=3;
            m.obj = texto;
            handler.sendMessage(m);
        }
        if (reiniciado){
            Message m = new Message();
            m.arg1=4;
            handler.sendMessage(m);
        }
    }


}