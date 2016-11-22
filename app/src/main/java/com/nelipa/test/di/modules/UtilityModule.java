package com.nelipa.test.di.modules;

import com.nelipa.test.s_randomizer.Push;
import com.nelipa.test.s_randomizer.Randomizer;
import com.nelipa.test.s_randomizer.Timer;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilityModule {

    @Provides
    Randomizer provideRandomizer(){
        return new Randomizer();
    }

    @Provides
    @Singleton
    Timer provideTimer(Randomizer randomizer, EventBus bus, Push push){
        return new Timer(bus, push, randomizer);
    }
}
