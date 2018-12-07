package com.sage.zujianhua;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.luojilab.component.componentlib.router.Router;
import com.luojilab.componentservice.readerbook.OneService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment;
    FragmentTransaction ft;

    Button installReadBookBtn;
    Button uninstallReadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        installReadBookBtn = (Button) findViewById(R.id.install_share);
        uninstallReadBtn = (Button) findViewById(R.id.uninstall_share);
        installReadBookBtn.setOnClickListener(this);
        uninstallReadBtn.setOnClickListener(this);
        showFragment();
    }

    private void showFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }


        Router router = Router.getInstance();
        if (router.getService(OneService.class.getSimpleName()) != null) {
            OneService service = (OneService) router.getService(OneService.class.getSimpleName());
            fragment = service.getOneFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.install_share:
                Router.registerComponent("com.sage.twocomponet.OneOneApplike");
                break;
            case R.id.uninstall_share:
                Router.unregisterComponent("com.sage.twocomponet.OneOneApplike");
                break;
        }
    }
}

