package com.nelipa.test.di.modules;

import android.content.Context;

import com.nelipa.test.a_container.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigationModule {
    private Context context;

    public NavigationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator(context);
    }
}
