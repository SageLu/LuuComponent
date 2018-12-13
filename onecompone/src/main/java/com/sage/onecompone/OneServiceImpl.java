package com.sage.onecompone;

import android.support.v4.app.Fragment;
import com.sage.onecompone.plugin.OneService;

public class OneServiceImpl implements OneService {

    @Override
    public Fragment getOneFragment() {
        return new OneFragment();
    }
}
