package com.nelipa.test.di.components;

import com.nelipa.test.a_container.ContainerActivity;
import com.nelipa.test.di.modules.AppModule;
import com.nelipa.test.di.modules.CommunicationModule;
import com.nelipa.test.di.modules.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                NavigationModule.class,
                CommunicationModule.class
        }
)

public interface MainComponent {
    void inject(ContainerActivity containerActivity);
}