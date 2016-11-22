package com.nelipa.test.di.modules;

import com.nelipa.test.s_randomizer.Randomizer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UtilityModule_ProvideRandomizerFactory implements Factory<Randomizer> {
  private final UtilityModule module;

  public UtilityModule_ProvideRandomizerFactory(UtilityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Randomizer get() {
    return Preconditions.checkNotNull(
        module.provideRandomizer(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Randomizer> create(UtilityModule module) {
    return new UtilityModule_ProvideRandomizerFactory(module);
  }
}
