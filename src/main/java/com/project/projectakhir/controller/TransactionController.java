package com.project.projectakhir.controller;

import com.project.projectakhir.entity.Transaction;
import com.project.projectakhir.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    private ResponseEntity<List<Transaction>> getAllTransaction(){
        return new ResponseEntity(transactionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Long id){
        return new ResponseEntity(transactionService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<List<Transaction>> getTransactionByIdUser(@PathVariable("id") Long id){
        return new ResponseEntity(transactionService.getAllByUser(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    private ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity(transactionService.createItem(transaction), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Transaction> updateTransactionById(@PathVariable("id") Long id,
                                                              @RequestBody Transaction transaction){
        return new ResponseEntity(transactionService.updateItem(id,transaction), HttpStatus.OK);
    }
}
