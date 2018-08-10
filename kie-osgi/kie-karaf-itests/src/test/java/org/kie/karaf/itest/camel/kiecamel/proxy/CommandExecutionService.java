package org.kie.karaf.itest.camel.kiecamel.proxy;

import org.kie.api.runtime.ExecutionResults;
import org.kie.karaf.itest.camel.kiecamel.model.Person;

/**
 * Proxy for testing KIE Command execution route.
 */
public interface CommandExecutionService {

    ExecutionResults executeCommandWithPerson(Person person);
}
