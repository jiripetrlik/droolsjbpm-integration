package org.kie.camel.container.module;

import java.util.HashSet;

import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import com.thoughtworks.xstream.security.TypePermission;
import org.kie.server.api.marshalling.xstream.XStreamMarshaller;

public class Marshaller {

    private final XStreamMarshaller xStreamMarshaller;

    public Marshaller() {
        xStreamMarshaller = new XStreamMarshaller(new HashSet<>(), Marshaller.class.getClassLoader());
        xStreamMarshaller.getXstream().addPermission(NoTypePermission.NONE);
        xStreamMarshaller.getXstream().addPermission(AnyTypePermission.ANY);
    }

    public String marshall(Object input) {
        return xStreamMarshaller.marshall(input);
    }

    public Object unmarshall(String input) {
        return xStreamMarshaller.unmarshall(input, Object.class);
    }
}
