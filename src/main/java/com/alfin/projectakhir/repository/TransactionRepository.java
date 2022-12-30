package com.alfin.projectakhir.repository;

import com.alfin.projectakhir.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
