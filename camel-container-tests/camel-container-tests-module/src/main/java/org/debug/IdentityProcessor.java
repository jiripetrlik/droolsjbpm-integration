package org.debug;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class IdentityProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Identity processor");
    }
}
