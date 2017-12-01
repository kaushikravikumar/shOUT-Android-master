package com.android.shout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by melody on 1/31/2017.
 */

public class SpeakAdapter extends RecyclerView.Adapter<SpeakAdapter.ViewHolder> {

    private ArrayList<String> titleList;

    private ArrayList<String> bodyList;

    private ArrayList<String> dateList;

    private Context c;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;
        TextView date;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            body = (TextView) v.findViewById(R.id.body);
            date = (TextView) v.findViewById(R.id.date);
        }
    }

    public SpeakAdapter(ArrayList<String> titleList, ArrayList<String> bodyList, ArrayList<String> dateList, Context c) {
        this.titleList = titleList;
        this.bodyList = bodyList;
        this.dateList = dateList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsfeeditem, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(titleList.get(position));
        holder.body.setText(bodyList.get(position));
        holder.date.setText(dateList.get(position));
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

}
