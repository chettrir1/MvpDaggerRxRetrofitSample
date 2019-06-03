package com.shiva.practice.di.components;

import android.content.Context;

import com.shiva.practice.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Retrofit exposeRetrofit();

    Context exposeContext();

}
