package com.nelipa.test.a_container;

import android.content.Context;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContainerActivity_MembersInjector implements MembersInjector<ContainerActivity> {
  private final Provider<Context> mContextProvider;

  private final Provider<Navigator> mNavigatorProvider;

  private final Provider<EventBus> mBusProvider;

  public ContainerActivity_MembersInjector(
      Provider<Context> mContextProvider,
      Provider<Navigator> mNavigatorProvider,
      Provider<EventBus> mBusProvider) {
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert mNavigatorProvider != null;
    this.mNavigatorProvider = mNavigatorProvider;
    assert mBusProvider != null;
    this.mBusProvider = mBusProvider;
  }

  public static MembersInjector<ContainerActivity> create(
      Provider<Context> mContextProvider,
      Provider<Navigator> mNavigatorProvider,
      Provider<EventBus> mBusProvider) {
    return new ContainerActivity_MembersInjector(
        mContextProvider, mNavigatorProvider, mBusProvider);
  }

  @Override
  public void injectMembers(ContainerActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mContext = mContextProvider.get();
    instance.mNavigator = mNavigatorProvider.get();
    instance.mBus = mBusProvider.get();
  }

  public static void injectMContext(
      ContainerActivity instance, Provider<Context> mContextProvider) {
    instance.mContext = mContextProvider.get();
  }

  public static void injectMNavigator(
      ContainerActivity instance, Provider<Navigator> mNavigatorProvider) {
    instance.mNavigator = mNavigatorProvider.get();
  }

  public static void injectMBus(ContainerActivity instance, Provider<EventBus> mBusProvider) {
    instance.mBus = mBusProvider.get();
  }
}
