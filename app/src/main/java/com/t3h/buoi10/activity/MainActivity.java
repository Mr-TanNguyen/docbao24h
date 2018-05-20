package com.t3h.buoi10.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.t3h.buoi10.R;
import com.t3h.buoi10.fragment.CaterogyNewsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitleToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.imv_back_tool_bar).setOnClickListener(this);
        tvTitleToolBar = findViewById(R.id.tv_title_tool_bar);
        addFragment(new CaterogyNewsFragment(), R.id.fragment_container, false);
    }


    public void addFragment(Fragment fragment, int rootId, boolean isAddToBackStack) {
        if (isAddToBackStack) {
            getSupportFragmentManager().beginTransaction()
                    .add(rootId, fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().add(rootId, fragment, fragment.getClass().getSimpleName()).commit();
        }
    }


    public void replaceFragment(Fragment fragment, int rootId, boolean isAddToBackStack) {
        if (isAddToBackStack) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit)
                    .replace(rootId, fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName()).commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit)
                    .replace(rootId, fragment, fragment.getClass().getSimpleName()).commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imv_back_tool_bar:
                popBack();
                break;
        }
    }

    private void popBack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }
    }

    public void setTitleToolBar(String title) {
        tvTitleToolBar.setText(title);
    }

}
