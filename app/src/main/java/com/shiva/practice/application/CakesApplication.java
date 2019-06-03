package com.shiva.practice.application;

import android.app.Application;

import com.shiva.practice.di.components.ApplicationComponent;
import com.shiva.practice.di.components.DaggerApplicationComponent;
import com.shiva.practice.di.module.ApplicationModule;


/*application is singleton object which will be available throughout entire lifecycle of the app*/
public class CakesApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule("https://gist.githubusercontent.com", this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
