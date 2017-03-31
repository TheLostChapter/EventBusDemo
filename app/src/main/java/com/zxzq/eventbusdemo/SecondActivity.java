package com.zxzq.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @InjectView(R.id.et_msg_input)
    EditText etMsgInput;
    @InjectView(R.id.btn_intentToMain)
    Button btnIntentToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_intentToMain)
    public void onViewClicked() {
        EventBus.getDefault().post(new MyEvent("Hello MainActivity"));
        startActivity(new Intent(this,MainActivity.class));
    }
}
