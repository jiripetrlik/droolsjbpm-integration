package org.kie.karaf.itest.camel.kiecamel.proxy;

import org.kie.karaf.itest.camel.kiecamel.model.Person;

/**
 * Proxy for testing age verification route.
 */
public interface AgeVerificationService {

    Person verifyAge(Person person);
}
