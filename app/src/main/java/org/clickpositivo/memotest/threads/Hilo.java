package org.clickpositivo.memotest.threads;

import android.os.Handler;
import android.os.Message;

public class Hilo extends Thread {

    private Handler handler;
    private int tiempo;

    public Hilo(Handler handler, int tiempo)
    {
        this.tiempo=tiempo;
        this.handler=handler;
    }

    @Override
    public void run() {
       try {
              Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                 return;
            }

        Message m = new Message();
        m.arg1=1;
        handler.sendMessage(m);

    }

}

