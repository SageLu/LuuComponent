package com.sage.onecompone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.luojilab.componentservice.share.bean.Author;

public class OneFragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.one_fragment, container,
                    false);
            rootView.findViewById(R.id.tv_content).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    goToShareActivityNormal();
//                    boolean b = UIRouter.getInstance().openUri(getActivity(), "componet://two", null);
//                    Toast.makeText(getActivity(), "rootview"+b, Toast.LENGTH_SHORT).show();
                }
            });

        }
        return rootView;
    }

    private void goToShareActivityNormal() {
        Author author = new Author();
        author.setName("Margaret Mitchell");
        author.setCounty("USA");
        ARouter.getInstance().build("/sage/twoActivity")
                .withString("bookName", "Gone with the Wind")
                .withObject("author", author)
                .navigation();
    }


}