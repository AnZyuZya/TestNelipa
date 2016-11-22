package com.nelipa.test.di.modules;

import android.content.Context;

import com.nelipa.test.a_login.GooglePlusHelper;
import com.nelipa.test.a_login.NetworkHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    private Context context;

    public NetworkModule(Context context) {
        this.context = context;
    }

    @Provides
    GooglePlusHelper provideGooglePlusHelper() {
        return new GooglePlusHelper(context);
    }

    @Provides
    NetworkHelper provideNetworkHelper() {
        return new NetworkHelper(context);
    }
}
