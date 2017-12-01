package com.android.shout.shout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SpeakOutFragment extends Fragment {

    public SpeakOutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference firebase = database.getReference("messages");
        final View view =  inflater.inflate(R.layout.speakout_fragment, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.speak);

        firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<SpeakOutEntry> data = new ArrayList<SpeakOutEntry>();
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    data.add(new SpeakOutEntry(d.child("body").getValue().toString(),
                                                d.child("date").getValue().toString(),
                                                d.child("title").getValue().toString()));
                }
                SpeakAdapter adapter = new SpeakAdapter(view.getContext(), data);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

}
