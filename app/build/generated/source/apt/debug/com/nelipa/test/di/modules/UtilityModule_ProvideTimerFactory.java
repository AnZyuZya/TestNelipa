package com.nelipa.test.di.modules;

import com.nelipa.test.s_randomizer.Push;
import com.nelipa.test.s_randomizer.Randomizer;
import com.nelipa.test.s_randomizer.Timer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UtilityModule_ProvideTimerFactory implements Factory<Timer> {
  private final UtilityModule module;

  private final Provider<Randomizer> randomizerProvider;

  private final Provider<EventBus> busProvider;

  private final Provider<Push> pushProvider;

  public UtilityModule_ProvideTimerFactory(
      UtilityModule module,
      Provider<Randomizer> randomizerProvider,
      Provider<EventBus> busProvider,
      Provider<Push> pushProvider) {
    assert module != null;
    this.module = module;
    assert randomizerProvider != null;
    this.randomizerProvider = randomizerProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
    assert pushProvider != null;
    this.pushProvider = pushProvider;
  }

  @Override
  public Timer get() {
    return Preconditions.checkNotNull(
        module.provideTimer(randomizerProvider.get(), busProvider.get(), pushProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Timer> create(
      UtilityModule module,
      Provider<Randomizer> randomizerProvider,
      Provider<EventBus> busProvider,
      Provider<Push> pushProvider) {
    return new UtilityModule_ProvideTimerFactory(
        module, randomizerProvider, busProvider, pushProvider);
  }
}
