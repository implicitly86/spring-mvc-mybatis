package com.implicitly.models;

/**
 * @author EMurzakaev@it.ru.
 */
public class Item {

    private final long id;
    private final String name;
    private final Category category;

    public Item() {
        this.id = -1;
        this.name = "";
        this.category = null;
    }

    public Item(long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Item(long id, String name, long categoryId) {
        this(id, name, new Category(categoryId, ""));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }

}
