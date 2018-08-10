package org.kie.karaf.itest.camel.kiecamel.tools;

import org.kie.karaf.itest.camel.kiecamel.model.Person;

public class PersonFactory {

    private PersonFactory() {
    }

    public static Person createOldPerson() {
        Person person = new Person();
        person.setName("Old Person");
        person.setAge(21);
        return person;
    }

    public static Person createYoungPerson() {
        Person person = new Person();
        person.setName("Young Person");
        person.setAge(18);
        return person;
    }

}
