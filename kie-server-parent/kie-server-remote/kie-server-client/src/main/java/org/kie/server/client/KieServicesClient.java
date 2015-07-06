/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.kie.server.client;

import org.kie.api.command.Command;
import org.kie.server.api.commands.CommandScript;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.api.model.KieScannerResource;
import org.kie.server.api.model.KieServerConfig;
import org.kie.server.api.model.KieServerInfo;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.ServiceResponsesList;

public interface KieServicesClient {

    <T> T getServicesClient(Class<T> serviceClient);

    ServiceResponse<KieServerInfo> register(String controllerEndpoint, KieServerConfig kieServerConfig);

    ServiceResponse<KieServerInfo> getServerInfo();

    ServiceResponse<KieContainerResourceList> listContainers();

    ServiceResponse<KieContainerResource> createContainer(String id, KieContainerResource resource);

    ServiceResponse<KieContainerResource> getContainerInfo(String id);

    ServiceResponse<Void> disposeContainer(String id);

    ServiceResponsesList executeScript(CommandScript script);

    ServiceResponse<KieScannerResource> getScannerInfo(String id);

    ServiceResponse<KieScannerResource> updateScanner(String id, KieScannerResource resource);

    ServiceResponse<ReleaseId> updateReleaseId(String id, ReleaseId releaseId);


    // for backward compatibility reason

    /**
     * This method is deprecated on KieServicesClient as it was moved to RuleServicesClient
     * @see RuleServicesClient#executeCommands(String, String)
     * @deprecated
     */
    @Deprecated
    ServiceResponse<String> executeCommands(String id, String payload);

    /**
     * This method is deprecated on KieServicesClient as it was moved to RuleServicesClient
     * @see RuleServicesClient#executeCommands(String, Command)
     * @deprecated
     */
    @Deprecated
    ServiceResponse<String> executeCommands(String id, Command<?> cmd);
}
