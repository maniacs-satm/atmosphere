/*
 * Copyright 2013 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.config.service;

import org.atmosphere.cpr.AtmosphereInterceptor;
import org.atmosphere.cpr.BroadcastFilter;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.DefaultBroadcaster;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for {@link org.atmosphere.cpr.AtmosphereHandler}
 *
 * @author Jeanfrancois Arcand
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AtmosphereHandlerService {

    /**
     * The {@link org.atmosphere.cpr.Broadcaster} class name
     *
     * @return The {@link org.atmosphere.cpr.Broadcaster} class name
     */
    Class<? extends Broadcaster> broadcaster() default DefaultBroadcaster.class;

    /**
     * A list of {@link BroadcastFilter}
     */
    Class<? extends BroadcastFilter>[] broadcastFilters() default {};

    /**
     * The mapping path, or context-root used to map this AtmosphereHandler
     * @return mapping path, or context-root used to map this AtmosphereHandler
     */
    String path() default "/";

    /**
     * Properties that will be passed to the associated {@link org.atmosphere.cpr.AtmosphereHandler}. Properties are defined
     * delimited using "=" and separated using coma.
     * @return an array of properties that will be passed to the associated {@link org.atmosphere.cpr.AtmosphereHandler}
     */
    String[] properties() default {};

    /**
     * Does this {@link org.atmosphere.cpr.AtmosphereHandler} support session
     * @return true if session are supported.
     */
    boolean supportSession() default false;

    /**
     * Atmosphere's config that will be passed to the associated {@link org.atmosphere.cpr.AtmosphereHandler}. Atmosphere's config are defined
     * delimited using "=" and separated using coma.
     * @return Atmosphere's config that will be passed to the associated {@link org.atmosphere.cpr.AtmosphereHandler}. Atmosphere's config are defined
     * delimited using "=" and separated using coma.
     */
    String[] atmosphereConfig() default {};

    /**
     * A list of {@link org.atmosphere.cpr.AtmosphereInterceptor} to install
     */
    Class<? extends AtmosphereInterceptor>[] interceptors() default {};
}
