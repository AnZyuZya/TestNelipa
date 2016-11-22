package com.nelipa.test.f_tab_two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nelipa.test.R;

public class TabTwoFragment extends Fragment {
    /*START LIFECYCLE*/
    public TabTwoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_two, container, false);
    }
    /*END LIFECYCLE*/
}
