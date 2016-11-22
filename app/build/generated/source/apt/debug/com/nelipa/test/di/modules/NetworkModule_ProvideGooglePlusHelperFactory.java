package com.nelipa.test.di.modules;

import com.nelipa.test.a_login.GooglePlusHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideGooglePlusHelperFactory
    implements Factory<GooglePlusHelper> {
  private final NetworkModule module;

  public NetworkModule_ProvideGooglePlusHelperFactory(NetworkModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public GooglePlusHelper get() {
    return Preconditions.checkNotNull(
        module.provideGooglePlusHelper(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<GooglePlusHelper> create(NetworkModule module) {
    return new NetworkModule_ProvideGooglePlusHelperFactory(module);
  }
}
