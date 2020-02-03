package com.lelabs.testapplication.app;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import java.lang.ref.WeakReference;

public class TestAppClass extends Application {
    private static WeakReference<TestAppClass> reference;

    @Override
    public void onCreate() {
        super.onCreate();
        //ACRA.init(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Context context=getApplicationContext();
        reference = new WeakReference<>(this);
//        FirebaseApp.initializeApp(context);
    }

    public static Context getContext() {
        return reference.get();
    }
}
