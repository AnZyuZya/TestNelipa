package com.nelipa.test.a_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.nelipa.test.R;
import com.nelipa.test.a_base.BaseActivity;
import com.nelipa.test.a_container.Navigator;
import com.nelipa.test.di.TestApp;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @Bind(R.id.btn_sign_in) SignInButton btnSignIn;

    //app module
    @Inject Context mContext;
    //network module
    @Inject GooglePlusHelper mGooglePlusHelper;
    @Inject NetworkHelper mNetworkHelper;
    //navigation module
    @Inject Navigator mNavigator;

    /*START LIFECYCLE*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((TestApp) getApplication()).getLoginComponent().inject(this); //inject classes
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == GooglePlusHelper.RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            mGooglePlusHelper.parseSignResult(result);
        }

        if (mGooglePlusHelper.isConnected()){
            mNavigator.startContainerActivity();
            finish();
        }
    }
    /*END LIFECYCLE*/

    /*START OnClick*/
    @SuppressWarnings("unused")
    @OnClick(R.id.btn_sign_in)
    public void onLoginClicked(View v){
        if (!mNetworkHelper.isOnline()) {
            mNetworkHelper.notifyNoInternet();
            return;
        }

        mGooglePlusHelper.login(this);
    }
    /*END OnClick*/

    private void init(){
        if (!mNetworkHelper.isOnline()) {
            mNetworkHelper.notifyNoInternet();
            return;
        }

        mGooglePlusHelper.buildClient(this);
        mGooglePlusHelper.initSignInButton(btnSignIn);
    }
}
