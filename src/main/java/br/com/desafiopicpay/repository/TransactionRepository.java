package br.com.desafiopicpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopicpay.transaction.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
