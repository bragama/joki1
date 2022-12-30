package com.alfin.projectakhir.service;

import com.alfin.projectakhir.entity.ItemCategory;
import com.alfin.projectakhir.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    public ItemCategory findById(Long id){
        return itemCategoryRepository.findById(id).get();
    }

    public List<ItemCategory> findAll(){
        return itemCategoryRepository.findAll();
    }

    public ItemCategory createItem(ItemCategory itemCategory){
        return itemCategoryRepository.saveAndFlush(itemCategory);
    }


    public ItemCategory updateItem(Long id,ItemCategory itemCategory){
        Optional<ItemCategory> itemCategory1 = itemCategoryRepository.findById(id);
        if (itemCategory1.isEmpty()){
            throw new RuntimeException("Id Not Enten");
        }
        return itemCategoryRepository.saveAndFlush(itemCategory);
    }
}
