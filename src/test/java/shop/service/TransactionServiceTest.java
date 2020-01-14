package shop.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import shop.model.Client;
import shop.model.Gun;
import shop.model.Seller;
import shop.model.Transaction;
import shop.repository.TransactionRepo;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class TransactionServiceTest {

    @Mock
    TransactionRepo transactionRepo;

    @InjectMocks
    TransactionService transactionService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    Transaction transaction = new Transaction(1,
            new Client(1,"Test","Test","adress","male",132L,33),
            new Seller(1, "Adam", "Surrname", 24, "Newbie"),
            new Gun(1,"producent","name","category",44F,12,2.46F,800F,56456),
            LocalDateTime.now());

    @Test
    public void shouldReturnTransactionNumberOne() {
        when(transactionRepo.findById(1)).thenReturn(java.util.Optional.of(transaction));

        Optional<Transaction> expectionTransactionById = Optional.ofNullable(transactionService.findtransactionById(1));

        Assert.assertEquals(expectionTransactionById, java.util.Optional.of(transaction));
    }

    @Test
    public void shouldAddNewTransaction() {
        when(transactionRepo.save(Mockito.any(Transaction.class))).thenReturn(transaction);

        Transaction transactionToSave = transactionService.addTransaction(new Transaction());

        Assert.assertEquals(transactionToSave, transaction);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldReturnExceptionWhenTryRemoveTransactionWithIdZero() {
        doThrow(EmptyResultDataAccessException.class).when(transactionRepo).deleteById(0);

        transactionService.deleteTransactionById(0);
    }

}