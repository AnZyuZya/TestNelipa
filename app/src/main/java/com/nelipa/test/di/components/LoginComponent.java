package com.nelipa.test.di.components;

import com.nelipa.test.a_login.LoginActivity;
import com.nelipa.test.di.modules.AppModule;
import com.nelipa.test.di.modules.NavigationModule;
import com.nelipa.test.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
                NavigationModule.class
        }
)

public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
