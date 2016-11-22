package com.nelipa.test.di.modules;

import com.nelipa.test.a_container.Navigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NavigationModule_ProvideNavigatorFactory implements Factory<Navigator> {
  private final NavigationModule module;

  public NavigationModule_ProvideNavigatorFactory(NavigationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Navigator get() {
    return Preconditions.checkNotNull(
        module.provideNavigator(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Navigator> create(NavigationModule module) {
    return new NavigationModule_ProvideNavigatorFactory(module);
  }
}
