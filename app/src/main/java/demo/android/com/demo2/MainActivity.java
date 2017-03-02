package demo.android.com.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start;
    private Button btn_stop;
    private Button btn_upload;
    private Button btn_launch;
    private Button btn_exit;
    private Bundle bundle;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_launch = (Button) findViewById(R.id.btn_launch);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_upload.setOnClickListener(this);
        btn_launch.setOnClickListener(this);
        btn_exit.setOnClickListener(this);

        intent = new Intent("com.zailingtech.yunti.CAPTURE_ACTION_START");
        bundle = new Bundle();
        bundle.putString("ID", "215552");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_launch:
                startActivity(intent);
                return;
            case R.id.btn_start:
                bundle.putString("action", "start");
                break;
            case R.id.btn_stop:
                bundle.putString("action", "stop");
                break;
            case R.id.btn_upload:
                bundle.putString("action", "upload");
                break;
            case R.id.btn_exit:
                bundle.putString("action", "exit");
                break;
        }
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

}
