package ak.try1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static String playerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }
    public void play(View v){
        EditText et = (EditText)findViewById(R.id.name_of_player);
        playerName = et.getText().toString();
        if(playerName.equals("")){
            Toast.makeText(this,"Enter Valid Name",Toast.LENGTH_SHORT).show();
        }
        else {
            setContentView(new ak.try1.GamePlay(this));
        }
    }
    public void about(View v){
        String url = "https://en.wikipedia.org/wiki/Monopoly_(game)";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public static void exit(View v){

        System.exit(1);
    }


}
