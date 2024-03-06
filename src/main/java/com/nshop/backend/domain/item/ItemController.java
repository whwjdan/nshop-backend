package com.nshop.backend.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;
    @Autowired
    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping("/api/items")
    public List<Item> getItems(){
        List<Item> items = itemRepository.findAll();

        return items;
    }
}
