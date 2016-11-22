package com.nelipa.test.s_randomizer;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RandomizerService_MembersInjector implements MembersInjector<RandomizerService> {
  private final Provider<Timer> mTimerProvider;

  public RandomizerService_MembersInjector(Provider<Timer> mTimerProvider) {
    assert mTimerProvider != null;
    this.mTimerProvider = mTimerProvider;
  }

  public static MembersInjector<RandomizerService> create(Provider<Timer> mTimerProvider) {
    return new RandomizerService_MembersInjector(mTimerProvider);
  }

  @Override
  public void injectMembers(RandomizerService instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mTimer = mTimerProvider.get();
  }

  public static void injectMTimer(RandomizerService instance, Provider<Timer> mTimerProvider) {
    instance.mTimer = mTimerProvider.get();
  }
}
