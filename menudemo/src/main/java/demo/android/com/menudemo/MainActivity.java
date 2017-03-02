package demo.android.com.menudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private int[] resIds;
    //    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        resIds = new int[]{R.drawable.lb_done, R.drawable.lb_unconfig, R.drawable.lb_unpass, R.drawable.lb_unsubmit, R.drawable.lb_untest};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (int i = 0; i < 5; i++) {
            MenuItem menuItem = menu.add(Menu.NONE, i, 0, "菜单" + i);
//            menuItem.setShowAsAction(Menu.FLAG_ALWAYS_PERFORM_CLOSE);//对应always
            menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        menuItem.setEnabled(false);
            menuItem.setIcon(resIds[i]);
        }
        return true;
    }

    /**
     * 通过反射，设置menu显示icon
     *
     * @param view
     * @param menu
     * @return
     */
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }
}
