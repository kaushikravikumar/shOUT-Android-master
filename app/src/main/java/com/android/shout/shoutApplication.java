package com.android.shout;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kaushikr on 2/1/18.
 */

public class shoutApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
