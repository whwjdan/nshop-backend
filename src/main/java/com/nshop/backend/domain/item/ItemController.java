package com.nshop.backend.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/api/items")
    public List<Item> getItems(){
        System.out.println("api 요청 1");
        List<Item> items = itemRepository.findAll();
        //System.out.println(items.get(0).getName());
        return items;
    }
}
