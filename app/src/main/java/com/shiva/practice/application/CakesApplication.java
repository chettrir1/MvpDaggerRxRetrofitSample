package com.shiva.practice.application;

import android.app.Application;

/*application is singleton object which will be available throughout entire lifecycle of the app*/
public class CakesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
