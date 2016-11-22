package com.nelipa.test.di;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.nelipa.test.di.components.DaggerLoginComponent;
import com.nelipa.test.di.components.DaggerMainComponent;
import com.nelipa.test.di.components.DaggerRandomizerComponent;
import com.nelipa.test.di.components.LoginComponent;
import com.nelipa.test.di.components.MainComponent;
import com.nelipa.test.di.components.RandomizerComponent;
import com.nelipa.test.di.modules.AppModule;
import com.nelipa.test.di.modules.CommunicationModule;
import com.nelipa.test.di.modules.NavigationModule;
import com.nelipa.test.di.modules.NetworkModule;
import com.nelipa.test.di.modules.UtilityModule;

import timber.log.BuildConfig;
import timber.log.Timber;

public class TestApp extends Application {
    private LoginComponent loginComponent;
    private MainComponent mainComponent;
    private RandomizerComponent randomizerComponent;

    @Override
    public void onCreate() {
        /*INIT Multidex*/
        MultiDex.install(this);
        super.onCreate();

        /*INIT Timber*/
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) { //display line number in logs
                    return "Timber -> " + super.createStackElementTag(element) + ':' + element.getLineNumber();
                }
            });
        }

        /*INIT Dagger2*/
        Context context = getApplicationContext();

        /*INIT LoginComponent*/
        loginComponent = DaggerLoginComponent.builder()
                .appModule(new AppModule(context))
                .networkModule(new NetworkModule(context))
                .navigationModule(new NavigationModule(context))
                .build();

        /*INIT MainComponent*/
        mainComponent = DaggerMainComponent.builder()
                .appModule(new AppModule(context))
                .navigationModule(new NavigationModule(context))
                .communicationModule(new CommunicationModule(context))
                .build();

        /*INIT RandomizerComponent*/
        randomizerComponent = DaggerRandomizerComponent.builder()
                .communicationModule(new CommunicationModule(context))
                .utilityModule(new UtilityModule())
                .build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    public RandomizerComponent getRandomizerComponent() {
        return randomizerComponent;
    }
}
