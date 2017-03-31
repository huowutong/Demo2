package demo.android.com.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start;
    private Button btn_stop;
    private Button btn_upload;
    private Button btn_launch;
    private Button btn_clear;
    private Button btn_start_check;
    private Button btn_stop_check;
    private Button btn_exit;
    private Bundle bundle;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        intent = new Intent("com.zailingtech.yunti.CAPTURE_ACTION_START");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        bundle = new Bundle();
        bundle.putString("ID", "215552");

        registerBroadcastReceiver();
    }

    private void registerBroadcastReceiver() {
        ActionReceiver receiver = new ActionReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.zailingtech.yunti.USAGEINFO");
        registerReceiver(receiver, filter);
    }

    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_launch = (Button) findViewById(R.id.btn_launch);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_start_check = (Button) findViewById(R.id.btn_start_check);
        btn_stop_check = (Button) findViewById(R.id.btn_stop_check);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_upload.setOnClickListener(this);
        btn_launch.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_start_check.setOnClickListener(this);
        btn_stop_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_launch:
//                startActivity(intent);
//                SystemClock.sleep(1000); //等待一段时间等待抓包APP完全启动并注册好广播监听
                bundle.putString("action", "start");
                break;
            case R.id.btn_start:
                bundle.putString("action", "start");
                break;
            case R.id.btn_stop:
                bundle.putString("action", "stop");
                break;
            case R.id.btn_upload:
                bundle.putString("action", "upload");
                break;
            case R.id.btn_clear:
                bundle.putString("action", "clear");
                break;
            case R.id.btn_start_check:
                bundle.putString("action", "startCheck");
                break;
            case R.id.btn_stop_check:
                bundle.putString("action", "stopCheck");
                break;
            case R.id.btn_exit:
                bundle.putString("action", "exit");
                break;
        }
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

    class ActionReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle == null) {
                return;
            }
            float cupUsage = bundle.getFloat("cupUsage");
            float memoryUsage = bundle.getFloat("memoryUsage");
            Log.e("CPU内存使用率", "CPU使用率：" + cupUsage + "%  " + "内存使用率：" + memoryUsage + "%");
        }
    }

}
