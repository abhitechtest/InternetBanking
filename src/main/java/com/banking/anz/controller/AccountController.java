package com.banking.anz.controller;

import com.banking.anz.model.Account;
import com.banking.anz.model.Transaction;
import com.banking.anz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping(value="/accounts/{accountNumber}")
    public List<Account> accounts(@PathVariable int accountNumber){
        return accountService.getAccounts(accountNumber);
    }

    @GetMapping(value="/accounts/{accountNumber}/transactions")
    public List<Transaction> transactions(@PathVariable int accountNumber){
        return accountService.getTransactions(accountNumber);
    }

}
