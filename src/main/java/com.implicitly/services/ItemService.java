package com.implicitly.services;

import com.implicitly.models.Item;

import java.util.List;

/**
 * @author EMurzakaev@it.ru.
 */
public interface ItemService {

    void addItem(final Item item);

    Item getItem(final long id);

    void updateItem(final Item item);

    void deleteItem(final long id);

    List<Item> getItems();

}
