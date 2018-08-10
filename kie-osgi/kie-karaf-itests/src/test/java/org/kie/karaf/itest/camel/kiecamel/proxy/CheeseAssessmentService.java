package org.kie.karaf.itest.camel.kiecamel.proxy;

import org.kie.karaf.itest.camel.kiecamel.model.Cheese;

/**
 * Proxy for testing cheese assessment route.
 */
public interface CheeseAssessmentService {

    Cheese assessCheese(Cheese cheese);
}
