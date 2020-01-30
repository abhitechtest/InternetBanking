package com.banking.anz.repository;

import com.banking.anz.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BankAccountRepository implements  AccountRepository{

    @Query(value = "SELECT a FROM Account a WHERE a.accountNumber = ?1", nativeQuery = true)
    public Account findOneAccount(int accountNumber) {
        return null;
    }
}
