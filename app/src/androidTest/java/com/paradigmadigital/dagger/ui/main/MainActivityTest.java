package com.paradigmadigital.dagger.ui.main;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.paradigmadigital.dagger.di.ApplicationComponent;
import com.paradigmadigital.dagger.platform.AndroidApplication;
import com.paradigmadigital.dagger.platform.ApplicationModule;
import com.paradigmadigital.dagger.ui.IAppCollaborator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import it.cosenonjaviste.daggermock.DaggerMockRule;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public DaggerMockRule<ApplicationComponent> rule =
            new DaggerMockRule<>(ApplicationComponent.class, new ApplicationModule())
                    .customizeBuilder(new DaggerMockRule.BuilderCustomizer<ApplicationComponent.Builder>() {
                        @Override
                        public ApplicationComponent.Builder customize(ApplicationComponent.Builder builder) {
                            return builder.application(getApp());
                        }
                    })
                    .set(new DaggerMockRule.ComponentSetter<ApplicationComponent>() {
                        @Override public void setComponent(ApplicationComponent component) {
                            component.inject(getApp());
                        }
                    });

    private AndroidApplication getApp() {
        return (AndroidApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Mock
    IAppCollaborator appCollaborator;

    @Test
    public void useAppContext() throws Exception {
        when(appCollaborator.getCollaboratorVersion()).thenReturn("Test collaborator version");

        activityRule.launchActivity(null);

        assertEquals("Test collaborator version", activityRule.getActivity().getTitle());
    }
}
