// Generated code from Icepick. Do not modify!
package com.nelipa.test.a_container;
import android.os.Bundle;
import icepick.Bundler;
import icepick.Injector.Helper;
import icepick.Injector.Object;

import java.util.Map;
import java.util.HashMap;

public class ContainerActivity$$Icepick<T extends ContainerActivity> extends Object<T> {

  private final static Map<String, Bundler<?>> BUNDLERS = new HashMap<String, Bundler<?>>();
  static {
      
  }

  private final static Helper H = new Helper("com.nelipa.test.a_container.ContainerActivity$$Icepick.", BUNDLERS);

  public void restore(T target, Bundle state) {
    if (state == null) return;
    target.mLastRandom = H.getString(state, "mLastRandom");
    super.restore(target, state);
  }

  public void save(T target, Bundle state) {
    super.save(target, state);
    H.putString(state, "mLastRandom", target.mLastRandom);
  }
}