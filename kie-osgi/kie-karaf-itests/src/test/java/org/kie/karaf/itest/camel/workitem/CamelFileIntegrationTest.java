package org.kie.karaf.itest.camel.workitem;

import org.apache.commons.io.FileUtils;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.impl.DefaultWorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItemManager;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

/**
 * Uploading a file via File endpoint using Camel in Fuse.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
@Ignore
public class CamelFileIntegrationTest {

    private static File tempDir;
    private static File testDir;
    private static File testFile;

    private KieServices kieServices;

    private KieSession kieSession;

    /*
    @org.ops4j.pax.exam.Configuration
    public Option[] config() throws IOException {
        return fuseDefaultConfiguration()
                .createConfigurationWithOtherOptions(
                        // installs transitively other Drools features
                        features(maven().groupId(BXMS_FEATURE_GROUP_ID).artifactId(BXMS_FEATURE_ARTIFACT_ID)
                                        .versionAsInProject().type("xml").classifier(BxMSFeatureUtils.getBxmsFeatureClassifier()),
                                JNDI_FEATURE_NAME, H2_FEATURE_NAME, HIBERNATE_FEATURE_NAME,
                                JBPM_FEATURE_NAME, DROOLS_DT_FEATURE_NAME),

                        features(maven().groupId(INTEG_PACK_FEATURE_GROUP_ID).artifactId(INTEG_PACK_FEATURE_ARTIFACT_ID)
                                        .versionAsInProject().type("xml").classifier("features"),
                                CAMEL_WORKITEM_FEATURE_NAME),

                        keepRuntimeFolder(),

                        wrappedBundle(mavenBundle().groupId("org.jboss.qa.droolsjbpm").artifactId("framework-fuse")
                                .versionAsInProject())
                );
    }

    @BeforeClass
    public static void initialize() {
        tempDir = new File(System.getProperty("java.io.tmpdir"));
        testDir = new File(tempDir, "test_dir");
        String fileName = "test_file_" + CamelFileIntegrationTest.class.getName() + "_" + UUID.randomUUID().toString();
        testFile = new File(tempDir, fileName);
    }

    @AfterClass
    public static void clean() throws IOException {
        FileUtils.deleteDirectory(testDir);
    }

    @Before
    public void prepare() {
        this.kieServices = KieServices.Factory.get();
        final KieContainer kieContainer = this.kieServices.newKieClasspathContainer(this.getClass().getClassLoader());
        this.kieSession = kieContainer.newKieSession("camel-workitem-ksession");
        Assert.assertNotNull(this.kieSession);
    }

    @After
    public void cleanup() {
        if (this.kieSession != null) {
            this.kieSession.dispose();
        }
    }


    @Test
    public void testSingleFileProcess() throws IOException {
        final String testData = "test-data";

        GenericCamelWorkiteHandler handler = CamelHandlerFactory.fileHandler();
        kieSession.getWorkItemManager().registerWorkItemHandler("CamelFile", handler);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("payloadVar", testData);
        params.put("pathVar", tempDir.getAbsolutePath());
        params.put("fileNameVar", testFile.getName());

        ProcessInstance pi = kieSession.startProcess("camelFileProcess", params);

        ProcessInstance result = kieSession.getProcessInstance(pi.getId());
        Assert.assertNotNull(result);

        Assert.assertTrue(testFile.exists());

        String resultText = FileUtils.readFileToString(testFile);
        Assert.assertEquals(testData, resultText);
    }

    @Test
    public void testSingleFileWithHeaders() throws IOException {
        Set<String> headers = new HashSet<String>();
        headers.add("CamelFileName");
        CamelHandler handler = new CamelHandler(new FileURIMapper(), new RequestPayloadMapper("payload", headers));

        final String testData = "test-data";
        final WorkItem workItem = new WorkItemImpl();
        workItem.setParameter("path", tempDir.getAbsolutePath());
        workItem.setParameter("payload", testData);
        workItem.setParameter("CamelFileName", testFile.getName());

        WorkItemManager manager = new DefaultWorkItemManager(null);
        handler.executeWorkItem(workItem, manager);

        Assert.assertTrue(testFile.exists());

        String resultText = FileUtils.readFileToString(testFile);
        Assert.assertEquals(testData, resultText);
    }*/
}
