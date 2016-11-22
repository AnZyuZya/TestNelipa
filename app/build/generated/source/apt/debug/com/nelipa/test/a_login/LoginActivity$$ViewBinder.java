// Generated code from Butter Knife. Do not modify!
package com.nelipa.test.a_login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.nelipa.test.a_login.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492985, "field 'btnSignIn' and method 'onLoginClicked'");
    target.btnSignIn = finder.castView(view, 2131492985, "field 'btnSignIn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onLoginClicked(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.btnSignIn = null;
  }
}
