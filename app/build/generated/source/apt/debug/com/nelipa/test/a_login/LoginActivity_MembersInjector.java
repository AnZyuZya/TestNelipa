package com.nelipa.test.a_login;

import android.content.Context;
import com.nelipa.test.a_container.Navigator;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final Provider<Context> mContextProvider;

  private final Provider<GooglePlusHelper> mGooglePlusHelperProvider;

  private final Provider<NetworkHelper> mNetworkHelperProvider;

  private final Provider<Navigator> mNavigatorProvider;

  public LoginActivity_MembersInjector(
      Provider<Context> mContextProvider,
      Provider<GooglePlusHelper> mGooglePlusHelperProvider,
      Provider<NetworkHelper> mNetworkHelperProvider,
      Provider<Navigator> mNavigatorProvider) {
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert mGooglePlusHelperProvider != null;
    this.mGooglePlusHelperProvider = mGooglePlusHelperProvider;
    assert mNetworkHelperProvider != null;
    this.mNetworkHelperProvider = mNetworkHelperProvider;
    assert mNavigatorProvider != null;
    this.mNavigatorProvider = mNavigatorProvider;
  }

  public static MembersInjector<LoginActivity> create(
      Provider<Context> mContextProvider,
      Provider<GooglePlusHelper> mGooglePlusHelperProvider,
      Provider<NetworkHelper> mNetworkHelperProvider,
      Provider<Navigator> mNavigatorProvider) {
    return new LoginActivity_MembersInjector(
        mContextProvider, mGooglePlusHelperProvider, mNetworkHelperProvider, mNavigatorProvider);
  }

  @Override
  public void injectMembers(LoginActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mContext = mContextProvider.get();
    instance.mGooglePlusHelper = mGooglePlusHelperProvider.get();
    instance.mNetworkHelper = mNetworkHelperProvider.get();
    instance.mNavigator = mNavigatorProvider.get();
  }

  public static void injectMContext(LoginActivity instance, Provider<Context> mContextProvider) {
    instance.mContext = mContextProvider.get();
  }

  public static void injectMGooglePlusHelper(
      LoginActivity instance, Provider<GooglePlusHelper> mGooglePlusHelperProvider) {
    instance.mGooglePlusHelper = mGooglePlusHelperProvider.get();
  }

  public static void injectMNetworkHelper(
      LoginActivity instance, Provider<NetworkHelper> mNetworkHelperProvider) {
    instance.mNetworkHelper = mNetworkHelperProvider.get();
  }

  public static void injectMNavigator(
      LoginActivity instance, Provider<Navigator> mNavigatorProvider) {
    instance.mNavigator = mNavigatorProvider.get();
  }
}
