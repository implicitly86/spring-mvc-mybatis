package com.implicitly.services;

import com.implicitly.models.Item;
import com.implicitly.persistence.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EMurzakaev@it.ru.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public void addItem(Item item) {
        itemMapper.addItem(item);
    }

    @Override
    public Item getItem(long id) {
        return itemMapper.getItem(id);
    }

    @Override
    public void updateItem(final Item item) {
        itemMapper.updateItem(item);
    }

    @Override
    public void deleteItem(long id) {
        itemMapper.deleteItem(id);
    }

    @Override
    public List<Item> getItems() {
        return itemMapper.getItems();
    }

}
