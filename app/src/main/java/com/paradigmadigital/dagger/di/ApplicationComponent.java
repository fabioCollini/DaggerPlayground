package com.paradigmadigital.dagger.di;

import com.paradigmadigital.dagger.platform.ActivityBindingModule;
import com.paradigmadigital.dagger.platform.AndroidApplication;
import com.paradigmadigital.dagger.platform.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ActivityBindingModule.class,
        ApplicationModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        Builder applicationModule(ApplicationModule applicationModule);

        @BindsInstance
        Builder application(AndroidApplication application);

        ApplicationComponent build();
    }

    ActivityComponent.Builder getActivityComponentBuilder();

}
