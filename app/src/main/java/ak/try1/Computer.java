package ak.try1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by new on 26-02-2016.
 */
public class Computer {
    private Bitmap player2 ;
    private GamePlay game;
    public static int posX;
    public static int posY;
    private TextView textview;
    private int x;
    private int y;
    public static int playerPos;



    public Computer(GamePlay game,Bitmap player1){
        this.game = game;
        this.player2 = player1;
        posX = GamePlay.ax;     //GamePlay.posarray[0][0];
        posY = GamePlay.ay;     /// GamePlay.posarray[0][1];
        x=0;
        y=0;
        playerPos = 0;
    }

    private void update(){

        playerPos  = playerPos + 1;
        if(playerPos > 35){
            playerPos = 0;
            GamePlay.money1 = GamePlay.money1 + 200;
        }

        if(GamePlay.z == GamePlay.dicenumber){
            if(playerPos == 27){
                playerPos = 9;
            }
            if(GamePlay.company[Computer.playerPos].equals("CHANCE") || GamePlay.company[Computer.playerPos].equals("Monopoly-Gift")){
                Random r = new Random();
                int z= r.nextInt()%2;
                int y = r.nextInt();
                if(y<0){
                    y=Math.abs(y);
                }
                int x = (y%30);
                x=x+20;
                if(z==0){
                    GamePlay.text = "Vision Get $"+x;
                    GamePlay.money1 += x;
                    GamePlay.scoreComputer += x;
                }
                else{
                    GamePlay.text = "Vision Pay Tax $"+x;
                    GamePlay.money1 -= x;
                }
            }
            if(GamePlay.company_owner[playerPos].equals("Player")){
                GamePlay.money1 = GamePlay.money1 - GamePlay.rent[playerPos];
                GamePlay.money2 += GamePlay.rent[playerPos];
            }
            else if(GamePlay.company_owner[playerPos].equals("Y")){
                Random r = new Random();
                int x = r.nextInt();
                if(x%2==0){
                    GamePlay.money1 = GamePlay.money1 - GamePlay.money[playerPos];
                    GamePlay.company_owner[playerPos]="Computer";
                    GamePlay.scoreComputer += GamePlay.money[playerPos];
                }
                else{
                    GamePlay.money1 = GamePlay.money1 - GamePlay.rent[playerPos];
                }
            }
            else{
                GamePlay.money1 = GamePlay.money1 - GamePlay.money[playerPos];
            }
        }


    }
    public void onDraw(Canvas canvas){
        if(GamePlay.dicenumber != 0)
                update();
        posX = (GamePlay.positionXArray[playerPos]);
        posY = (GamePlay.positionYArray[playerPos]);
        canvas.drawBitmap(player2,(GamePlay.positionXArray[playerPos]),(GamePlay.positionYArray[playerPos]),null);

    }

    public static float convertDpToPixel(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}
