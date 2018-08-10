package org.kie.karaf.itest.camel.kiecamel.tools;

import org.kie.api.definition.type.FactType;

public class PersonGavFactory {

    private PersonGavFactory() {
    }

    public static Object createOldPerson(FactType personType) throws IllegalAccessException, InstantiationException {
        Object person = personType.newInstance();
        personType.set(person, "name", "Old person");
        personType.set(person, "age", 21);

        return person;
    }

    public static Object createYoungPerson(FactType personType) throws IllegalAccessException, InstantiationException {
        Object person = personType.newInstance();
        personType.set(person, "name", "Young person");
        personType.set(person, "age", 18);

        return person;
    }
}
