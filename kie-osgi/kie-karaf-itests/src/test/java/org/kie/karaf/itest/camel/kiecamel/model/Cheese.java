package org.kie.karaf.itest.camel.kiecamel.model;

public class Cheese {

    private String type;
    private int price;
    private boolean favourite;

    public Cheese() {
    }

    public Cheese(final String type, final int price) {
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFavourite() {
        return this.favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
