package com.android.shout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SpeakOutFragment extends Fragment {

    Button makeblogpost;

    public SpeakOutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference firebase = database.getReference("messages");
        final View view = inflater.inflate(R.layout.speakout_fragment, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> titleList = new ArrayList<String>();
                ArrayList<String> bodyList = new ArrayList<String>();
                ArrayList<String> dateList = new ArrayList<String>();
                ArrayList<String> timeList = new ArrayList<String>();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Message m = d.getValue(Message.class);
                    bodyList.add(m.getBody().toString());
                    dateList.add(m.getDate().toString());
                    titleList.add(m.getTitle().toString());
                    timeList.add(m.getTime().toString());
                }
                SpeakAdapter adapter = new SpeakAdapter(titleList, bodyList, dateList, timeList, view.getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        makeblogpost = (Button) view.findViewById(R.id.makeblogpost);
        makeblogpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ReportIncident.class));
            }
        });

        return view;
    }

}
