package com.nelipa.test.di.components;

import android.content.Context;
import com.nelipa.test.a_container.Navigator;
import com.nelipa.test.a_login.GooglePlusHelper;
import com.nelipa.test.a_login.LoginActivity;
import com.nelipa.test.a_login.LoginActivity_MembersInjector;
import com.nelipa.test.a_login.NetworkHelper;
import com.nelipa.test.di.modules.AppModule;
import com.nelipa.test.di.modules.AppModule_ProvideApplicationContextFactory;
import com.nelipa.test.di.modules.NavigationModule;
import com.nelipa.test.di.modules.NavigationModule_ProvideNavigatorFactory;
import com.nelipa.test.di.modules.NetworkModule;
import com.nelipa.test.di.modules.NetworkModule_ProvideGooglePlusHelperFactory;
import com.nelipa.test.di.modules.NetworkModule_ProvideNetworkHelperFactory;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerLoginComponent implements LoginComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<GooglePlusHelper> provideGooglePlusHelperProvider;

  private Provider<NetworkHelper> provideNetworkHelperProvider;

  private Provider<Navigator> provideNavigatorProvider;

  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private DaggerLoginComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationContextProvider =
        ScopedProvider.create(AppModule_ProvideApplicationContextFactory.create(builder.appModule));

    this.provideGooglePlusHelperProvider =
        NetworkModule_ProvideGooglePlusHelperFactory.create(builder.networkModule);

    this.provideNetworkHelperProvider =
        NetworkModule_ProvideNetworkHelperFactory.create(builder.networkModule);

    this.provideNavigatorProvider =
        ScopedProvider.create(
            NavigationModule_ProvideNavigatorFactory.create(builder.navigationModule));

    this.loginActivityMembersInjector =
        LoginActivity_MembersInjector.create(
            provideApplicationContextProvider,
            provideGooglePlusHelperProvider,
            provideNetworkHelperProvider,
            provideNavigatorProvider);
  }

  @Override
  public void inject(LoginActivity loginActivity) {
    loginActivityMembersInjector.injectMembers(loginActivity);
  }

  public static final class Builder {
    private AppModule appModule;

    private NetworkModule networkModule;

    private NavigationModule navigationModule;

    private Builder() {}

    public LoginComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (networkModule == null) {
        throw new IllegalStateException(NetworkModule.class.getCanonicalName() + " must be set");
      }
      if (navigationModule == null) {
        throw new IllegalStateException(NavigationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerLoginComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder navigationModule(NavigationModule navigationModule) {
      this.navigationModule = Preconditions.checkNotNull(navigationModule);
      return this;
    }
  }
}
