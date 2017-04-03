package ak.try1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by new on 28-02-2016.
 */
public class Manager {

    private GamePlay game;
    private Bitmap rolling;
    private Bitmap finish;

    public Manager(){

    }
    public Manager(GamePlay game, Bitmap roll,Bitmap fin){
        this.game = game;
        rolling = roll;
        finish = fin;
    }


    public void onDraw(Canvas canvas){
            //canvas.drawBitmap(GamePlay.playersign, 100, 100, null);
    }
}
