package com.android.yuanxiong.cpapademo2.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.fragment.LeftFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.RightFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.mainLeft)
    Button mainLeft;
    @Bind(R.id.mainRight)
    Button mainRight;
    @Bind(R.id.mainText)
    TextView mainText;
    @Bind(R.id.mainFrameLayout)
    FrameLayout mainFrameLayout;
    @Bind(R.id.left)
    FrameLayout left;
    @Bind(R.id.right)
    FrameLayout right;
    @Bind(R.id.mainDrawerLayout)
    DrawerLayout mainDrawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.left, new LeftFragment());
        transaction.replace(R.id.right, new RightFragment());
        transaction.commit();
    }

    @OnClick({R.id.mainLeft, R.id.mainRight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainLeft:
                mainDrawerLayout.openDrawer(left);
                break;
            case R.id.mainRight:
                mainDrawerLayout.openDrawer(right);
                break;
        }
    }

    public void switchContentFragment(LeftTagModel model) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.content, model.getFragment());
        transaction.commit();
        mainDrawerLayout.closeDrawers();
        changeTitle(model.getName());
    }

    private void changeTitle(String name) {
        mainText.setText(name);
    }
}
