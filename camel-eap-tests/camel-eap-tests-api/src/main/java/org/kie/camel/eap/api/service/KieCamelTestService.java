package org.kie.camel.eap.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.drools.core.command.runtime.process.StartProcessCommand;
import org.drools.core.runtime.impl.ExecutionResultImpl;
import org.kie.api.command.Command;
import org.kie.camel.eap.api.model.Person;

@Path("/kie-service")
public interface KieCamelTestService {

    @POST
    @Path("/age-verification")
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    Person verifyAge(Person person);

    @POST
    @Path("/start-process")
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    ExecutionResultImpl startProcessCommand(StartProcessCommand command);
}
