package com.qychbb.www.rainbowbaby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class SplashActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        toolbar = (Toolbar) findViewById(R.id.id_tool_bar);
        setTitle("Enic");
        setSupportActionBar(toolbar);
    }
}
