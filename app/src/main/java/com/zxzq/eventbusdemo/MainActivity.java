package com.zxzq.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_intentToSecond)
    Button btnIntentToSecond;
    @InjectView(R.id.tv_showMsg)
    TextView tvShowMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.btn_intentToSecond)
    public void onViewClicked() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * MAIN.
     * ASYNC.
     * BACKGROUND.
     * POSTING
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MyEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tvShowMsg.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
