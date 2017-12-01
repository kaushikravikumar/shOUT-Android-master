package com.android.shout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ComposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);
    }

    public void post(View v) {

        startActivity(new Intent(ComposeActivity.this, MainActivity.class));
    }

    public void cancel(View v) {
        startActivity(new Intent(ComposeActivity.this, MainActivity.class));
    }
}

