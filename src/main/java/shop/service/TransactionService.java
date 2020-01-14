package shop.service;


import org.springframework.stereotype.Service;
import shop.model.Transaction;
import shop.repository.TransactionRepo;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    public Transaction findtransactionById(Integer id) {
        if(transactionRepo.findById(id).isPresent())
            return transactionRepo.findById(id).get();
        else
            return null;
    }

    public List<Transaction> showAllTransaction() {
        return transactionRepo.findAll();
    }

    public void deleteTransactionById(Integer id) {
        transactionRepo.deleteById(id);
    }

}
