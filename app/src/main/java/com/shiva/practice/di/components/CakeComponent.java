package com.shiva.practice.di.components;

import com.shiva.practice.di.module.ApplicationModule;
import com.shiva.practice.di.module.CakeModule;
import com.shiva.practice.di.scope.PerActivity;
import com.shiva.practice.modules.home.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {
    void inject(MainActivity activity);
}
