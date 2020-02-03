package com.banking.anz.repository;

import com.banking.anz.model.Account;
import com.banking.anz.model.Transaction;
import com.banking.anz.model.type.AccountType;
import com.banking.anz.model.type.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testFindAll() {
        List<Transaction> allTransactions = transactionRepository.findAll();
        assertThat(allTransactions.size() == 3);
    }


}


