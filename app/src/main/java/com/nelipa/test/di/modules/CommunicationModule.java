package com.nelipa.test.di.modules;

import android.content.Context;

import com.nelipa.test.s_randomizer.Push;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

@Module
public class CommunicationModule {
    private Context context;

    public CommunicationModule(Context context) {
        this.context = context;
    }

    @Provides
    EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Provides
    Push providePush(){
        return new Push(context);
    }
}
