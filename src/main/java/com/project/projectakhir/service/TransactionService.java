package com.project.projectakhir.service;

import com.project.projectakhir.entity.Transaction;
import com.project.projectakhir.repository.TransactionRepository;
import com.project.projectakhir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;
    public Transaction findById(Long id){
        return transactionRepository.findById(id).get();
    }

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public List<Transaction> getAllByUser(Long idUser){
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction> arrayTransaction = new ArrayList<>();

        transactions.forEach(e->{
            if (e.getUser().getId().equals(idUser)){
                arrayTransaction.add(e);
            }
        });
        return arrayTransaction;
    }

    public Transaction createItem(Transaction transaction){
        return transactionRepository.saveAndFlush(transaction);
    }


    public Transaction updateItem(Long id,Transaction transaction){
        Optional<Transaction> transaction1 = transactionRepository.findById(id);
        if (transaction1.isEmpty()){
            throw new RuntimeException("Id Not Enten");
        }
        return transactionRepository.saveAndFlush(transaction);
    }
}
