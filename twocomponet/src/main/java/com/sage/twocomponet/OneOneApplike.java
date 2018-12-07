package com.sage.twocomponet;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.ui.UIRouter;

public class OneOneApplike implements IApplicationLike {

    //Router router = Router.getInstance();
//    UIRouter uiRouter = UIRouter.getInstance();
//    OneOneUIRouter shareUIRouter = OneOneUIRouter.getInstance();

    @Override
    public void onCreate() {
        //注入
        //router.addService(OneOneService.class.getSimpleName(), new OneOneServiceImpl());
//        uiRouter.registerUI(shareUIRouter);
        ShareInterceptor.isRegister = true;
    }

    @Override
    public void onStop() {
        //移除
        //router.removeService(OneOneService.class.getSimpleName());
//        uiRouter.unregisterUI(shareUIRouter);
        ShareInterceptor.isRegister = false;
    }
}