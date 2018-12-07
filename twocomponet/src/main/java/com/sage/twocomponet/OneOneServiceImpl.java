package com.sage.twocomponet;

import android.support.v4.app.Fragment;

import com.luojilab.componentservice.readerbook.OneOneService;

public class OneOneServiceImpl implements OneOneService {
    @Override
    public Fragment getTwoFragment() {
        return new OneOneFragment();
    }
}