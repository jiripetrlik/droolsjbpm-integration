package org.kie.camel.container.integration.tests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.kie.camel.container.api.model.Person;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.api.model.ReleaseId;

public class RemoteIntegrationTest extends AbstractKieCamelIntegrationTest {

    @Test
    public void listContainersTest() throws InterruptedException {
        final String containerId = "test-container";
        final ReleaseId releaseId = new ReleaseId("org.drools",
                                            "camel-container-tests-kjar",
                                            "7.15.0-SNAPSHOT");
        final KieContainerResource kieContainerResource = new KieContainerResource(releaseId);
        kieContainerResource.setContainerId(containerId);
        kieCamelTestService.esCreateContainer(containerId, kieContainerResource);
        KieContainerResourceList kieContainerResourceList = kieCamelTestService.esListContainers();
        Assertions.assertThat(kieContainerResourceList.getContainers().size()).isGreaterThan(0);
    }
}
