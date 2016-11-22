package com.nelipa.test.a_container;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.nelipa.test.R;
import com.nelipa.test.a_base.BaseActivity;
import com.nelipa.test.di.TestApp;
import com.nelipa.test.events.ERandom;
import com.nelipa.test.s_randomizer.Randomizer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import goldzweigapps.tabs.View.EasyTabs;
import icepick.Icepick;
import icepick.State;

public class ContainerActivity extends BaseActivity {
    @Bind(R.id.easy_tabs) EasyTabs easyTabs;
    @Bind(R.id.tv_random) TextView tvRandom;

    //app module
    @Inject Context mContext;
    //navigation module
    @Inject Navigator mNavigator;
    //communication module
    @Inject EventBus mBus;

    @State String mLastRandom;

    /*START LIFECYCLE*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_container);
        ((TestApp) getApplication()).getMainComponent().inject(this); //inject classes
        ButterKnife.bind(this);
        if (!mBus.isRegistered(this)) {
            mBus.register(this);
        }
        mNavigator.startService();


        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        mNavigator.stopService();
        if (mBus.isRegistered(this)) {
            mBus.unregister(this);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        readArguments(intent);
    }

    /*END LIFECYCLE*/

    /*START EVENTS*/
    @SuppressWarnings("unused")
    @Subscribe
    public void onRandomGenerated(ERandom event){
        if (event == null){
            return;
        }

        runOnUiThread(() -> { //run in UI thread since event comes from background
            mLastRandom = String.valueOf(event.getNewRandom());
            displayRandomValue();
        });
    }
    /*END EVENTS*/

    private void init(){
        mNavigator.initTabNavigation(easyTabs);
        //restore last value
        displayRandomValue();
    }


    private void displayRandomValue(){
        if (mLastRandom != null && tvRandom != null){
            tvRandom.setText(mLastRandom);
        }
    }

    private void readArguments(Intent intent){
        if (intent != null && intent.hasExtra(Randomizer.BUNDLE_LAST_RANDOM)){
            mLastRandom = intent.getStringExtra(Randomizer.BUNDLE_LAST_RANDOM);
            displayRandomValue();
        }
    }
}
