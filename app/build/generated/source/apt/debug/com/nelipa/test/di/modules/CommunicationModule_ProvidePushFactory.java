package com.nelipa.test.di.modules;

import com.nelipa.test.s_randomizer.Push;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommunicationModule_ProvidePushFactory implements Factory<Push> {
  private final CommunicationModule module;

  public CommunicationModule_ProvidePushFactory(CommunicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Push get() {
    return Preconditions.checkNotNull(
        module.providePush(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Push> create(CommunicationModule module) {
    return new CommunicationModule_ProvidePushFactory(module);
  }
}
