package com.nelipa.test.di.modules;

import com.nelipa.test.a_login.NetworkHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideNetworkHelperFactory implements Factory<NetworkHelper> {
  private final NetworkModule module;

  public NetworkModule_ProvideNetworkHelperFactory(NetworkModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public NetworkHelper get() {
    return Preconditions.checkNotNull(
        module.provideNetworkHelper(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NetworkHelper> create(NetworkModule module) {
    return new NetworkModule_ProvideNetworkHelperFactory(module);
  }
}
