package com.qychbb.www.rainbowbaby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle2.LifecycleTransformer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.mText)
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    @OnClick(R.id.mText)
    @Override
    public void onClick(View view) {
        Toast.makeText(this,"OK",Toast.LENGTH_LONG).show();
    }

}
