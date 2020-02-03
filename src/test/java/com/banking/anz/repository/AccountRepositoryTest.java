package com.banking.anz.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.banking.anz.model.Account;
import com.banking.anz.model.Transaction;
import com.banking.anz.model.type.AccountType;
import com.banking.anz.model.type.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testFindAll() {
        List<Account> allAccounts = accountRepository.findAll();
        assertThat(allAccounts.size() == 3);
    }

    @Test
    public void testFindOneAccount() {
        Account account = accountRepository.findById(0001).get();
        assertThat(account.getAccountName() == "Account 1");
    }

    @Test
    public void testSave() {
        double amt = 10.0;
        List<Transaction> transactions = null;
        Account newAccount = accountRepository.save(new Account(1, "Account 1",
                AccountType.CURRENT.toString(), new Date(), Currency.AUD.toString(), amt, transactions)) ;
        Optional<Account> searchedAccount = accountRepository.findById(1);
        assertThat(newAccount.getAccountNumber() == searchedAccount.get().getAccountNumber());
    }

    @Test
    public void testDelete() {
        Account account = accountRepository.findById(0001).get();
        accountRepository.deleteById(account.getAccountNumber());
       try{
           Account findAccount = accountRepository.findById(0001).get();
       }catch(NoSuchElementException e){
            assertThat(true);
        }

    }
}


