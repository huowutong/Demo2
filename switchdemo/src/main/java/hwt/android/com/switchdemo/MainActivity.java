package hwt.android.com.switchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Switch swt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swt = (Switch) findViewById(R.id.swt);
        swt.setChecked(true);
        btn = (Button) findViewById(R.id.btn);
        swt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        swt.setSelected(!swt.isSelected());
    }
}
