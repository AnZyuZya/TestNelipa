package com.nelipa.test.a_login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import timber.log.Timber;

public class GooglePlusHelper implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {
    static final int RC_SIGN_IN = 123;

    private Context context;

    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions googleSignInOptions;

    private boolean isConnected;

    public GooglePlusHelper(Context context) {
        this.context = context;

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void initSignInButton(SignInButton signInButton){
        if (signInButton == null){
            return;
        }

        if (googleSignInOptions == null){
            throw new RuntimeException("Failed to build GoogleSignInOptions");
        }

        signInButton.setSize(SignInButton.SIZE_WIDE);
        signInButton.setScopes(googleSignInOptions.getScopeArray());
    }

    public void login(Activity activity){
        if (activity == null){
            return;
        }

        if (googleApiClient == null){
            throw new RuntimeException("Failed to build API client. Make sure buildClient() is called!");
        }

        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void parseSignResult(GoogleSignInResult result) {
        if (result == null){
            isConnected = false;
            return;
        }

        Timber.d("Is succeed: %1s", result.isSuccess());
        Timber.d("Status: %1s", result.getStatus());

        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            String userName = acct != null && acct.getDisplayName() != null ? acct.getDisplayName() : "Undefined";
            Toast.makeText(context, "Logged in as: " + userName, Toast.LENGTH_LONG).show();
            isConnected = true;
        } else {
            // Signed out, show unauthenticated UI.
            Toast.makeText(context, "Failed to log in!", Toast.LENGTH_LONG).show();
            isConnected = false;
        }
    }

    public void buildClient(FragmentActivity activity){
        if (activity == null || googleSignInOptions == null){
            throw new RuntimeException("Failed to build GoogleSignInOptions");
        }

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        googleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(activity /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addConnectionCallbacks(this /*ConnectionCallback*/)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // Signed out, show unauthenticated UI.
        isConnected = false;
        Toast.makeText(context, "Failed to connect to Google API!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        isConnected = true;
    }

    @Override
    public void onConnectionSuspended(int i) {
        isConnected = false;
    }
}
