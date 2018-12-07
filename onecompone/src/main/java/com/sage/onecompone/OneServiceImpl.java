package com.sage.onecompone;

import android.support.v4.app.Fragment;

import com.luojilab.componentservice.readerbook.OneService;

public class OneServiceImpl implements OneService {

    @Override
    public Fragment getOneFragment() {
        return new OneFragment();
    }
}
