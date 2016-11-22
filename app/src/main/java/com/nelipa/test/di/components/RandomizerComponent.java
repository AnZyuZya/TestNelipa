package com.nelipa.test.di.components;

import com.nelipa.test.di.modules.CommunicationModule;
import com.nelipa.test.di.modules.UtilityModule;
import com.nelipa.test.s_randomizer.RandomizerService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                CommunicationModule.class,
                UtilityModule.class
        }
)

public interface RandomizerComponent {
    void inject(RandomizerService randomizerService);
}