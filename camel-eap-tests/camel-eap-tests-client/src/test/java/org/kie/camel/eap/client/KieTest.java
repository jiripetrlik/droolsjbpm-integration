package org.kie.camel.eap.client;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.assertj.core.api.Assertions;
import org.drools.core.command.runtime.process.StartProcessCommand;
import org.drools.core.runtime.impl.ExecutionResultImpl;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.command.KieCommands;
import org.kie.camel.eap.api.model.Person;
import org.kie.camel.eap.api.service.KieCamelTestService;

public class KieTest {

    private static final String TEST_PROCESS_ID = "process1";
    private static final String PROCESS_INSTANCE_ID_PROPERTY = "process-id";

    private KieCamelTestService kieCamelTestService;

    @Before
    public void init() {
        kieCamelTestService = JAXRSClientFactory.create("http://localhost:8080/rest", KieCamelTestService.class);
    }

    @Test
    public void testKie() {
        Person person = new Person();
        person.setName("George");
        person.setAge(15);
        Person response = kieCamelTestService.verifyAge(person);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.isCanDrink()).isFalse();

        person = new Person();
        person.setName("John");
        person.setAge(25);
        response = kieCamelTestService.verifyAge(person);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.isCanDrink()).isTrue();
    }

    @Test
    public void testStartProcess() {
        final KieCommands kieCommands = KieServices.Factory.get().getCommands();

        final StartProcessCommand command = (StartProcessCommand) kieCommands.newStartProcess(TEST_PROCESS_ID);
        command.setOutIdentifier(PROCESS_INSTANCE_ID_PROPERTY);
        final ExecutionResultImpl response = kieCamelTestService.startProcessCommand(command);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getResults().get(PROCESS_INSTANCE_ID_PROPERTY)).isNotNull();
    }
}
