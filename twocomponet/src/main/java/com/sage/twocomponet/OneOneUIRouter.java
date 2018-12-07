//package com.sage.twocomponet;
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.text.TextUtils;
//
//import com.luojilab.component.componentlib.router.ui.IComponentRouter;
//
//public class OneOneUIRouter implements IComponentRouter {
//
//    private static final String SCHME = "componet";
//
//    private static final String SHAREHOST = "two";
//
//    private static String[] HOSTS = new String[]{SHAREHOST};
//
//    private static OneOneUIRouter instance = new OneOneUIRouter();
//
//    private OneOneUIRouter() {
//
//    }
//
//    public static OneOneUIRouter getInstance() {
//        return instance;
//    }
//
//    @Override
//    public boolean openUri(Context context, String url, Bundle bundle) {
//        if (TextUtils.isEmpty(url) || context == null) {
//            return true;
//        }
//        return openUri(context, Uri.parse(url), bundle);
//    }
//
//    @Override
//    public boolean openUri(Context context, Uri uri, Bundle bundle) {
//        if (uri == null || context == null) {
//            return true;
//        }
//        String host = uri.getHost();
//        if (SHAREHOST.equals(host)) {
//            Intent intent = new Intent(context, MainActivity.class);
//            intent.putExtras(bundle == null ? new Bundle() : bundle);
//            context.startActivity(intent);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean verifyUri(Uri uri) {
//        String scheme = uri.getScheme();
//        String host = uri.getHost();
//        if (SCHME.equals(scheme)) {
//            for (String str : HOSTS) {
//                if (str.equals(host)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}