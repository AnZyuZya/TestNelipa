// Generated code from Butter Knife. Do not modify!
package com.nelipa.test.a_container;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ContainerActivity$$ViewBinder<T extends com.nelipa.test.a_container.ContainerActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492984, "field 'easyTabs'");
    target.easyTabs = finder.castView(view, 2131492984, "field 'easyTabs'");
    view = finder.findRequiredView(source, 2131492983, "field 'tvRandom'");
    target.tvRandom = finder.castView(view, 2131492983, "field 'tvRandom'");
  }

  @Override public void unbind(T target) {
    target.easyTabs = null;
    target.tvRandom = null;
  }
}
