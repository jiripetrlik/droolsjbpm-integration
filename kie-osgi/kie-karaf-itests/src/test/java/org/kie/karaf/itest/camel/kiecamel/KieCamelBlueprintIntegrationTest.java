package org.kie.karaf.itest.camel.kiecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.component.bean.PojoProxyHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.karaf.itest.AbstractKarafIntegrationTest;
import org.kie.karaf.itest.camel.kiecamel.model.Person;
import org.kie.karaf.itest.camel.kiecamel.proxy.AgeVerificationService;
import org.kie.karaf.itest.camel.kiecamel.tools.PersonFactory;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import javax.inject.Inject;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureConsole;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.debugConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.logLevel;

/**
 * Basic KIE-Camel with Blueprint functional tests running in Fuse.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class KieCamelBlueprintIntegrationTest extends AbstractKarafIntegrationTest {

    @Inject
    private CamelContext camelContext;

    @Configuration
    public static Option[] configure() {
        return new Option[]{
                // Install Karaf Container
                getKarafDistributionOption(),

                // Don't bother with local console output as it just ends up cluttering the logs
                configureConsole().ignoreLocalConsole(),
                // Force the log level to INFO so we have more details during the test.  It defaults to WARN.
                logLevel(LogLevelOption.LogLevel.DEBUG),

                // Option to be used to do remote debugging
                // debugConfiguration("5005", true),

                // Load Kie-Aries-Blueprint
                loadKieFeatures("drools-module", "kie-ci", "kie-aries-blueprint", "kie-camel"),

                // wrap and install junit bundle - the DRL imports a class from it
                // (simulates for instance a bundle with domain classes used in rules)
                wrappedBundle(mavenBundle().groupId("junit").artifactId("junit").versionAsInProject())
        };
    }

    @Test(timeout = 60000)
    public void testOldPerson() throws Exception {
        final AgeVerificationService service = getAgeVerificationProxy();
        final Person verifiedPerson = service.verifyAge(PersonFactory.createOldPerson());

        Assert.assertTrue(verifiedPerson.isCanDrink());
    }

    @Test(timeout = 60000)
    public void testYoungPerson() throws Exception {
        final AgeVerificationService service = getAgeVerificationProxy();
        final Person verifiedPerson = service.verifyAge(PersonFactory.createYoungPerson());

        Assert.assertFalse(verifiedPerson.isCanDrink());
    }

    private AgeVerificationService getAgeVerificationProxy() throws Exception {
        // need to use PojoProxyHelper to avoid sending BeanInvocation object as payload
        return PojoProxyHelper.createProxy(camelContext.getEndpoint("direct://startAgeVerification"),
                AgeVerificationService.class);
    }
}
