package ak.try1;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by new on 20-02-2016.
 */
public class GameThread extends Thread {

    private GamePlay game;
    private boolean running;

    public GameThread(GamePlay game){
        this.game = game;
    }

    public void setRunning(boolean run){
        running = run;
    }
    @SuppressLint("WrongCall")
    @Override
    public void run(){

       // while(running){
            Canvas c = null;
            try{
                c = game.getHolder().lockCanvas();
                synchronized (game.getHolder()){
                    game.onDraw(c);
                }
            }
            finally {
                if(c!=null){
                    game.getHolder().unlockCanvasAndPost(c);
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




       // }
    }

}
