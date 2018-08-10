package org.kie.karaf.itest.camel.kiecamel.tools;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to help create wrapper Drools Expert Command for use with
 * org.drools/drools-camel component.
 */
public class DroolsCommandHelper {

    public void insertAndFireAll(Exchange exchange) {
        final Message in = exchange.getIn();
        final Object body = in.getBody();

        final KieCommands kieCommands = KieServices.Factory.get().getCommands();

        final List<Command> commands = new ArrayList<Command>();
        // since KIE commands are JAXB-annotated, the body has to be JAXB annotated class as well
        commands.add(kieCommands.newInsert(body, "person"));
        commands.add(kieCommands.newFireAllRules());

        BatchExecutionCommand command = kieCommands.newBatchExecution(commands);
        in.setBody(command);
    }

}
