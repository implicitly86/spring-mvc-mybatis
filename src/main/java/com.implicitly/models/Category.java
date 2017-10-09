package com.implicitly.models;

/**
 * @author EMurzakaev@it.ru.
 */
public class Category {

    private final long id;
    private final String name;

    public Category() {
        this.id = -1;
        this.name = "";
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
