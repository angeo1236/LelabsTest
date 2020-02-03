package com.lelabs.testapplication.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;

import java.lang.ref.WeakReference;

public class TestAppClass extends Application {
    private static WeakReference<TestAppClass> reference;

    private static TestAppClass instance;

    public static boolean hasNetwork() {
        return instance.isNetworkConnected();
    }

    public static Context getContext() {
        return reference.get();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //ACRA.init(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Context context = getApplicationContext();
        reference = new WeakReference<>(this);
        if (instance == null) {
            instance = this;
        }
    }

    public static TestAppClass getInstance(){
        return instance;
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
