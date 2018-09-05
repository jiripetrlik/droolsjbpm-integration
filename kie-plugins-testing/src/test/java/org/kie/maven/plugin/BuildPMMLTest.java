package org.kie.maven.plugin;

import java.io.File;

import io.takari.maven.testing.executor.MavenExecutionResult;
import io.takari.maven.testing.executor.MavenRuntime;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.maven.plugin.BuildMojoIntegrationTest;

public class BuildPMMLTest extends KieMavenPluginBaseIntegrationTest {

    private String PROJECT_NAME = "kjar-6-with-pmml";

    private String GAV_GROUP_ID = "org.kie";
    private String GAV_ARTIFACT_ID = "kie-maven-plugin-test-kjar-6";
    private String GAV_VERSION = "1.0.0.Final";

    public BuildPMMLTest(MavenRuntime.MavenRuntimeBuilder builder) throws Exception {
        super(builder);
    }

    @Test
    public void testCleanInstallWithPMML() throws Exception {
        File basedir = resources.getBasedir(PROJECT_NAME);
        MavenExecutionResult result = mavenRuntime
                .forProject(basedir)
                .execute("clean",
                         "install");
        result.assertErrorFreeLog();
    }

    @Test
    public void testUseBuildKjarWithPMML() throws Exception {
        File basedir = resources.getBasedir(PROJECT_NAME);
        MavenExecutionResult result = mavenRuntime
                .forProject(basedir)
                .execute("clean",
                         "install");
        result.assertErrorFreeLog();

        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId(GAV_GROUP_ID, GAV_ARTIFACT_ID, GAV_VERSION);
        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
        Assertions.assertThat(kieContainer).isNotNull();
    }
}
