package com.shiva.practice.di.module;

import com.shiva.practice.api.CakeApiService;
import com.shiva.practice.di.scope.PerActivity;
import com.shiva.practice.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class CakeModule {
    private MainView mView;

    public CakeModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }
}
