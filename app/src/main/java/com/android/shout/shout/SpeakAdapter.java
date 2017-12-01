package com.android.shout.shout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


/**
 * Created by melody on 1/31/2017.
 */

public class SpeakAdapter extends ArrayAdapter<SpeakOutEntry> {

    public SpeakAdapter(Context context, List<SpeakOutEntry> data){
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        SpeakOutEntry speak = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView body = (TextView) convertView.findViewById(R.id.body);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        title.setText(speak.title);
        body.setText(speak.body);
        date.setText(speak.date);

        return convertView;

    }

}
