package com.sage.twocomponet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.luojilab.componentservice.share.bean.Author;

@Route(path = "/sage/twoActivity")
public class MainActivity extends AppCompatActivity {

    @Autowired(name = "bookName")
    String magazineName;

    @Autowired
    Author author;


    TextView tv_two, tv_two_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneone);
        tv_two = findViewById(R.id.tv_two);


        Log.e("Two", "two activity");
        ARouter.getInstance().inject(this);

        tv_two.setText(magazineName);
        tv_two_content = findViewById(R.id.tv_two_content);

        if (author != null) {
            tv_two_content.setText(author.getCounty());
        }
    }
}
