package com.paradigmadigital.dagger.platform;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.paradigmadigital.dagger.di.ApplicationComponent;
import com.paradigmadigital.dagger.di.DaggerApplicationComponent;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent = createComponent();

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    @VisibleForTesting
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
