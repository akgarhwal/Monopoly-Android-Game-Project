package ak.try1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gaurav on 4/5/2016.
 */
public class listAdapter extends BaseAdapter {
    ArrayList<String> name;
    ArrayList<Integer> score;
    LayoutInflater lf;
    public listAdapter(Context c,ArrayList<String> n,ArrayList<Integer> s){
        name=n;
        score=s;
        lf=LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ll = (LinearLayout) lf.inflate(R.layout.leader_view, parent, false);
        TextView sn, sc;
        sn = (TextView) ll.findViewById(R.id.textName);
        sc = (TextView) ll.findViewById(R.id.textScore);
        sn.setText(name.get(position));
        sc.setText(""+score.get(position));
        return ll;
    }
}
