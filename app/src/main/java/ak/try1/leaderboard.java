package ak.try1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class leaderboard extends Activity {

    public static int score;
    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_leaderboard);
        Intent i = getIntent();
        write(new View(this));
        read(new View(this));

    }
    public void write(View v)
    {
        try{
            FileOutputStream fo = openFileOutput("abcde.txt",
                    Context.MODE_APPEND);
//append already existing file then use Context.MODE_APPEND |
           // Context.MODE_PRIVATE;

            String str=name+"$"+score+"$";
            fo.write(str.getBytes());
            fo.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void read(View v)
    {
        try {
            String str = "";
            TextView t1 = (TextView) findViewById(R.id.textName1);
            TextView t2 = (TextView) findViewById(R.id.textScore1);
            TextView t3 = (TextView) findViewById(R.id.textName2);
            TextView t4 = (TextView) findViewById(R.id.textScore2);
            TextView t5 = (TextView) findViewById(R.id.textName3);
            TextView t6 = (TextView) findViewById(R.id.textScore3);

            FileInputStream fi = openFileInput("abcde.txt");
            int c;
            while ((c = fi.read()) != -1) {
                str = str + (char) c;
            }
            String name1[] = new String[3];
            int sc1[] = new int[3];
            int y=0,x=0,z=0;
            for(int i=0;i<str.length() && y<3;i++){
                if(str.charAt(i)=='$' && z==0){
                    name1[y] = str.substring(x,i);
                    x=i+1;
                    z=1;
                }
                else if(str.charAt(i)=='$'){
                    sc1[y] = Integer.parseInt(str.substring(x,i));
                    z=0;
                    y++;
                    x=i+1;
                }
            }

            t1.setText("Atul");
            t2.setText("3845");
            t3.setText("Niraj");
            t4.setText("2923");
            t5.setText("Abhinesh");
            t6.setText("2886");
            fi.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
