package org.kie.camel.container.integration.tests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.kie.camel.container.api.model.Person;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.api.model.ReleaseId;

public class RemoteIntegrationTest extends AbstractKieCamelIntegrationTest {

    private static final String TEST_JAR_GROUP_ID = "org.drools";
    private static final String TEST_JAR_ARTIFACT_ID = "camel-container-tests-kjar";

    @Test
    public void listContainersTest() throws InterruptedException {
        final String containerId = "test-container";
        final ReleaseId releaseId = new ReleaseId(TEST_JAR_GROUP_ID,
                                            TEST_JAR_ARTIFACT_ID,
                                            testProperties.getProperty(PROJECT_VERSION_TEST_PROPERTY));
        final KieContainerResource kieContainerResource = new KieContainerResource(releaseId);
        kieContainerResource.setContainerId(containerId);

        KieContainerResource resource = kieCamelTestService.esCreateContainer(containerId, kieContainerResource);
        Assertions.assertThat(resource).isNotNull();

        KieContainerResourceList kieContainerResourceList = kieCamelTestService.esListContainers();

        Assertions.assertThat(kieContainerResourceList.getContainers().size()).isGreaterThan(0);
    }
}
