package com.speedy.io.test.merchantAPI;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.test.context.ActiveProfilesResolver;

public class JunitProfileResolver implements ActiveProfilesResolver {

    private static final String DEV_PROFILE = "dev";

    @Override
    public String[] resolve(Class<?> testClass) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, DEV_PROFILE);
        return new String[] {DEV_PROFILE};
    }
}
