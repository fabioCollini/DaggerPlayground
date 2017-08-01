package com.paradigmadigital.dagger.platform;

import android.content.Context;

import com.paradigmadigital.dagger.ui.AppCollaborator;
import com.paradigmadigital.dagger.ui.IAppCollaborator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    public Context provideContext(AndroidApplication application) {
        return application;
    }

    @Provides
    @Singleton
    public IAppCollaborator provideAppCollaborator() {
        return new AppCollaborator();
    }
}
