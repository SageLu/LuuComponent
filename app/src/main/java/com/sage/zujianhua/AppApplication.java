package com.sage.zujianhua;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
//        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
//        Router.registerComponent("com.sage.onecompone.OneAppLike");
//
//        Router.registerComponent("com.sage.twocomponet.OneOneApplike");
    }
}
