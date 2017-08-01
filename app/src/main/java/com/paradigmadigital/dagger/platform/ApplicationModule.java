package com.paradigmadigital.dagger.platform;

import android.content.Context;

import com.paradigmadigital.dagger.ui.AppCollaborator;
import com.paradigmadigital.dagger.ui.IAppCollaborator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    public Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public IAppCollaborator provideAppCollaborator() {
        return new AppCollaborator();
    }
}
