package com.nelipa.test.a_login;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import timber.log.Timber;

public class NetworkHelper {
    private Context context;

    public NetworkHelper(Context context) {
        this.context = context;
    }

    public boolean isOnline() {
        if (context == null) {
            Timber.e("No Internet connection");
            return false;
        }

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void notifyNoInternet(){
        Toast.makeText(context, "Please make sure you connected to Network", Toast.LENGTH_SHORT).show();
    }
}
