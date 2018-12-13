package com.sage.onecompone;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
//import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.Router;
import com.sage.onecompone.plugin.OneService;

public class OneAppLike implements IApplicationLike {

    Router router = Router.getInstance();

    @Override
    public void onCreate() {
        //注入
        router.addService(OneService.class.getSimpleName(), new OneServiceImpl());
    }

    @Override
    public void onStop() {
        //移除
        router.removeService(OneService.class.getSimpleName());
    }
}