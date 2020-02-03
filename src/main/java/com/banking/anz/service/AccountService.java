package com.banking.anz.service;


import com.banking.anz.exception.AccountNotFoundException;
import com.banking.anz.exception.AccountNumberMissingException;
import com.banking.anz.model.Account;
import com.banking.anz.model.Transaction;
import com.banking.anz.repository.AccountRepository;
import com.banking.anz.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {



    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    public List<Account> getAccounts(int accountNumber){
        List<Account> accountList = null;
        if(accountNumber > 0){
            accountList = new ArrayList<>();
            Account account = accountRepository.findById(accountNumber).get();
            if(null == account){
                throw new AccountNotFoundException("This Account does not exist");

            }
            return accountList;
        }
        return accountRepository.findAll();
    }

    public List<Transaction> getTransactions(int accountNumber){
        List<Transaction> transactionList = null;
        if(accountNumber > 0){
            return transactionRepository.findAll();
        }else
        throw new AccountNumberMissingException("Account number missing in the request");
    }
}
