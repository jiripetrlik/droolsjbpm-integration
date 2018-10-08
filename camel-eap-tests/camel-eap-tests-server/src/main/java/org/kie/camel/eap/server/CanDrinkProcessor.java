package org.kie.camel.eap.server;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CanDrinkProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object object = exchange.getIn().getBody();
        exchange.getIn().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN);
        exchange.getIn().setBody("Hello world!!!");
    }
}
