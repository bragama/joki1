package com.alfin.projectakhir.controller;

import com.alfin.projectakhir.entity.ItemCategory;
import com.alfin.projectakhir.entity.User;
import com.alfin.projectakhir.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item-category")
public class ItemCategoryController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    private ResponseEntity<List<ItemCategory>> getAllItems(){
        return new ResponseEntity(itemService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    private ResponseEntity<ItemCategory> getItemById(@PathVariable("id") Long id){
        return new ResponseEntity(itemService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    private ResponseEntity<ItemCategory> createItem(@RequestBody ItemCategory itemCategory){
        return new ResponseEntity(itemService.createItem(itemCategory), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    private ResponseEntity<ItemCategory> updateItemById(@PathVariable("id") Long id,
                                                @RequestBody ItemCategory itemCategory){
        return new ResponseEntity(itemService.updateItem(id, itemCategory), HttpStatus.OK);
    }
}
