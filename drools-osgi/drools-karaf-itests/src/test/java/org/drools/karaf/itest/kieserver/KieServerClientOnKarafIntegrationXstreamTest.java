/*
 * Copyright 2015 Red Hat
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.drools.karaf.itest.kieserver;

import org.drools.karaf.itest.AbstractKarafIntegrationTest;
import org.drools.karaf.itest.util.PaxExamWithWireMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;


@RunWith(PaxExamWithWireMock.class)
@ExamReactorStrategy(PerMethod.class)
public class KieServerClientOnKarafIntegrationXstreamTest extends BaseKieServerClientOnKarafIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger(KieServerClientOnKarafIntegrationXstreamTest.class);
    public static final String HOST = "localhost";
    public static final int PORT = 59500;
    public static final String TYPE = "xstream";

    public KieServerClientOnKarafIntegrationXstreamTest() {
        serverUrl = System.getProperty("org.kie.server.itest.server.url", "http://" + HOST + ":" + PORT);
    }

    @Test
    public void testListContainersXSTREAM() throws Exception {

        testListContainers(MarshallingFormat.XSTREAM);

    }

    @Test
    public void testCompleteInteractionWithKieServerXSTREAM() throws Exception {

        testCompleteInteractionWithKieServer(MarshallingFormat.XSTREAM);

    }

    @Configuration
    public static Option[] configure() {

        return new Option[]{
                // Install Karaf Container
                AbstractKarafIntegrationTest.getKarafDistributionOption(),

                // Don't bother with local console output as it just ends up cluttering the logs
                configureConsole().ignoreLocalConsole(),
                // Force the log level to INFO so we have more details during the test.  It defaults to WARN.
                logLevel(LogLevelOption.LogLevel.INFO),

                // Option to be used to do remote debugging
//                  debugConfiguration("5005", true),

                // Load kie-server-client
                AbstractKarafIntegrationTest.loadKieFeatures("kie-server-client")
        };
    }

}