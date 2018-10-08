package org.kie.camel.eap.server;

import java.util.Set;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class IdentityProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Processor");
    }
}
