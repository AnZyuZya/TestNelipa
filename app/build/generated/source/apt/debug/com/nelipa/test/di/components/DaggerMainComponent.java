package com.nelipa.test.di.components;

import android.content.Context;
import com.nelipa.test.a_container.ContainerActivity;
import com.nelipa.test.a_container.ContainerActivity_MembersInjector;
import com.nelipa.test.a_container.Navigator;
import com.nelipa.test.di.modules.AppModule;
import com.nelipa.test.di.modules.AppModule_ProvideApplicationContextFactory;
import com.nelipa.test.di.modules.CommunicationModule;
import com.nelipa.test.di.modules.CommunicationModule_ProvideEventBusFactory;
import com.nelipa.test.di.modules.NavigationModule;
import com.nelipa.test.di.modules.NavigationModule_ProvideNavigatorFactory;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainComponent implements MainComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<Navigator> provideNavigatorProvider;

  private Provider<EventBus> provideEventBusProvider;

  private MembersInjector<ContainerActivity> containerActivityMembersInjector;

  private DaggerMainComponent(Builder builder) {
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

    this.provideNavigatorProvider =
        ScopedProvider.create(
            NavigationModule_ProvideNavigatorFactory.create(builder.navigationModule));

    this.provideEventBusProvider =
        CommunicationModule_ProvideEventBusFactory.create(builder.communicationModule);

    this.containerActivityMembersInjector =
        ContainerActivity_MembersInjector.create(
            provideApplicationContextProvider, provideNavigatorProvider, provideEventBusProvider);
  }

  @Override
  public void inject(ContainerActivity containerActivity) {
    containerActivityMembersInjector.injectMembers(containerActivity);
  }

  public static final class Builder {
    private AppModule appModule;

    private NavigationModule navigationModule;

    private CommunicationModule communicationModule;

    private Builder() {}

    public MainComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (navigationModule == null) {
        throw new IllegalStateException(NavigationModule.class.getCanonicalName() + " must be set");
      }
      if (communicationModule == null) {
        throw new IllegalStateException(
            CommunicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerMainComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder navigationModule(NavigationModule navigationModule) {
      this.navigationModule = Preconditions.checkNotNull(navigationModule);
      return this;
    }

    public Builder communicationModule(CommunicationModule communicationModule) {
      this.communicationModule = Preconditions.checkNotNull(communicationModule);
      return this;
    }
  }
}
