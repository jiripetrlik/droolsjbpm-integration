package org.kie.karaf.itest.camel.kiecamel.tools;

import org.kie.karaf.itest.camel.kiecamel.model.Cheese;

public class CheeseFactory {

    private CheeseFactory() {
    }

    public static Cheese createStilton() {
        Cheese cheese = new Cheese();
        cheese.setType("stilton");
        cheese.setPrice(10);
        return cheese;
    }

    public static Cheese createCheddar() {
        Cheese cheese = new Cheese();
        cheese.setType("cheddar");
        cheese.setPrice(50);
        return cheese;
    }
}
