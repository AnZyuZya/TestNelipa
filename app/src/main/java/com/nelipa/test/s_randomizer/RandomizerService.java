package com.nelipa.test.s_randomizer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.nelipa.test.di.TestApp;

import javax.inject.Inject;

public class RandomizerService extends Service {
    @Inject Timer mTimer;

    public void onCreate() {
        super.onCreate();
        ((TestApp) getApplication()).getRandomizerComponent().inject(this); //inject classes
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        mTimer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        mTimer.stop();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
