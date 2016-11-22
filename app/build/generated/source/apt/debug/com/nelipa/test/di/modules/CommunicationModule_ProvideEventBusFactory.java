package com.nelipa.test.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import org.greenrobot.eventbus.EventBus;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommunicationModule_ProvideEventBusFactory implements Factory<EventBus> {
  private final CommunicationModule module;

  public CommunicationModule_ProvideEventBusFactory(CommunicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public EventBus get() {
    return Preconditions.checkNotNull(
        module.provideEventBus(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<EventBus> create(CommunicationModule module) {
    return new CommunicationModule_ProvideEventBusFactory(module);
  }
}
