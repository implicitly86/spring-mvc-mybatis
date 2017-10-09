package com.implicitly.controllers;

import com.implicitly.models.Item;
import com.implicitly.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author EMurzakaev@it.ru.
 */
@RestController
public class MainController {

    private final ItemService itemService;

    @Autowired
    public MainController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable final long id, HttpServletResponse response) {
        final Item item = itemService.getItem(id);
        if (item == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return item;
    }

    @PutMapping("/item")
    public void updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable final long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

}
