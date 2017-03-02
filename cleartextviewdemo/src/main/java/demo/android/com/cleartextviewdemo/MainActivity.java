package demo.android.com.cleartextviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.tv01)
    TextView tv01;
    @Bind(R.id.ctl01)
    ClearEditText ctl01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        ctl01.setText("摄像头名称");
    }
}
