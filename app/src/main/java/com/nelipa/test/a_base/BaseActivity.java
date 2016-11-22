package com.nelipa.test.a_base;

import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public static boolean isInFocus;

    /*START LIFECYCLE*/
    @Override
    protected void onResume() {
        super.onResume();
        isInFocus = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isInFocus = false;
    }

    /*END LIFECYCLE*/
}
