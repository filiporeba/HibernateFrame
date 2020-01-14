package shop.controller;

import org.springframework.web.bind.annotation.*;
import shop.model.Transaction;
import shop.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.showAllTransaction();
    }

    @GetMapping(value = "/transactions/{id}")
    public Transaction getTransaction(@PathVariable Integer id) {
        return transactionService.findtransactionById(id);
    }

    @PostMapping(value = "/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @PutMapping(value = "/transactions")
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @DeleteMapping(value = "/transactions/{id}")
    public void deleteTransaction(@PathVariable Integer id) {
        transactionService.deleteTransactionById(id);
    }
}
