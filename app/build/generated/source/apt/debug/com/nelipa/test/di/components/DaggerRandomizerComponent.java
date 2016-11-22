package com.nelipa.test.di.components;

import com.nelipa.test.di.modules.CommunicationModule;
import com.nelipa.test.di.modules.CommunicationModule_ProvideEventBusFactory;
import com.nelipa.test.di.modules.CommunicationModule_ProvidePushFactory;
import com.nelipa.test.di.modules.UtilityModule;
import com.nelipa.test.di.modules.UtilityModule_ProvideRandomizerFactory;
import com.nelipa.test.di.modules.UtilityModule_ProvideTimerFactory;
import com.nelipa.test.s_randomizer.Push;
import com.nelipa.test.s_randomizer.Randomizer;
import com.nelipa.test.s_randomizer.RandomizerService;
import com.nelipa.test.s_randomizer.RandomizerService_MembersInjector;
import com.nelipa.test.s_randomizer.Timer;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerRandomizerComponent implements RandomizerComponent {
  private Provider<Randomizer> provideRandomizerProvider;

  private Provider<EventBus> provideEventBusProvider;

  private Provider<Push> providePushProvider;

  private Provider<Timer> provideTimerProvider;

  private MembersInjector<RandomizerService> randomizerServiceMembersInjector;

  private DaggerRandomizerComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideRandomizerProvider =
        UtilityModule_ProvideRandomizerFactory.create(builder.utilityModule);

    this.provideEventBusProvider =
        CommunicationModule_ProvideEventBusFactory.create(builder.communicationModule);

    this.providePushProvider =
        CommunicationModule_ProvidePushFactory.create(builder.communicationModule);

    this.provideTimerProvider =
        ScopedProvider.create(
            UtilityModule_ProvideTimerFactory.create(
                builder.utilityModule,
                provideRandomizerProvider,
                provideEventBusProvider,
                providePushProvider));

    this.randomizerServiceMembersInjector =
        RandomizerService_MembersInjector.create(provideTimerProvider);
  }

  @Override
  public void inject(RandomizerService randomizerService) {
    randomizerServiceMembersInjector.injectMembers(randomizerService);
  }

  public static final class Builder {
    private UtilityModule utilityModule;

    private CommunicationModule communicationModule;

    private Builder() {}

    public RandomizerComponent build() {
      if (utilityModule == null) {
        this.utilityModule = new UtilityModule();
      }
      if (communicationModule == null) {
        throw new IllegalStateException(
            CommunicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerRandomizerComponent(this);
    }

    public Builder communicationModule(CommunicationModule communicationModule) {
      this.communicationModule = Preconditions.checkNotNull(communicationModule);
      return this;
    }

    public Builder utilityModule(UtilityModule utilityModule) {
      this.utilityModule = Preconditions.checkNotNull(utilityModule);
      return this;
    }
  }
}
