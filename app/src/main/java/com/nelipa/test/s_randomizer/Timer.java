package com.nelipa.test.s_randomizer;

import android.os.Handler;

import com.nelipa.test.a_base.BaseActivity;
import com.nelipa.test.events.ERandom;

import org.greenrobot.eventbus.EventBus;

public class Timer {
    private EventBus mBus;
    private Push mPush;
    private Randomizer mRandomizer;

    public Timer(EventBus mBus, Push push, Randomizer mRandomizer) {
        this.mBus = mBus;
        this.mPush = push;
        this.mRandomizer = mRandomizer;
    }

    private boolean isTimerStarted;
    private int counter; //for seconds counting

    private Handler mTimerHandler = new Handler();
    private Runnable mTimerRunnable = new Runnable() {
        @Override
        public void run() {
            counter++;
            if (counter == 10){ //trigger every 10 sec
                trigger();
            }

            if (isTimerStarted) {
                mTimerHandler.postDelayed(this, 1000); //tick every second
            }
        }
    };

    public void start() {
        if (!isTimerStarted) {
            isTimerStarted = true;
            mTimerHandler.postDelayed(mTimerRunnable, 0);
        }
    }

    public void stop(){
        if (mTimerHandler != null && mTimerRunnable != null) {
            isTimerStarted = false;
            mTimerHandler.removeCallbacks(mTimerRunnable);
        }
    }

    private void trigger(){
        counter = 0;
        int random = mRandomizer.generate(100, 1000);//let be random from 100 to 1000

        if (BaseActivity.isInFocus) { //if in focus change value
            mBus.post(new ERandom(random));
        } else { //if not in focus send notification
            mPush.sendNotification(random);
        }
    }

}
