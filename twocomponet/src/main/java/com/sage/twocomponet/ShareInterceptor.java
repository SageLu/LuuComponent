package com.sage.twocomponet;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.luojilab.component.basiclib.MainLooper;

@Interceptor(priority = 1, name = "分享组件拦截器")
public class ShareInterceptor implements IInterceptor {

    public static boolean isRegister;
    Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (!isRegister
                && ("/sage/twoActivity".equals(postcard.getPath())
                || "/share/shareMagazine".equals(postcard.getPath()))) {
            MainLooper.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext, "Two组件已经卸载", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            callback.onContinue(postcard);
        }

    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}