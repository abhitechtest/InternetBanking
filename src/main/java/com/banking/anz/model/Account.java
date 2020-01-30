package com.banking.anz.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="Account Details")
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer accountNumber;

    @Size(min = 3, message = "Account Name should have at least 3 characters")
    @ApiModelProperty(notes="Account Name")
    private String accountName;

    @ApiModelProperty(notes="Account Type")
    private String accountType;


    @ApiModelProperty(notes="Balance Date")
    private Date balanceDate;

    @ApiModelProperty(notes="Currency")
    private String currency;

    @ApiModelProperty(notes="Opening Available Balance")
    private double openingAvailableBalance;

    @OneToMany(mappedBy="account")
    private List<Transaction> transactions;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getOpeningAvailableBalance() {
        return openingAvailableBalance;
    }

    public void setOpeningAvailableBalance(double openingAvailableBalance) {
        this.openingAvailableBalance = openingAvailableBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    protected Account() { }

    public Account(Integer accountNumber,
                   @Size(min = 2, message = "Account Name should have at least 3 characters") String accountName,
                   @NotBlank String accountType,Date balanceDate,
                   String currency, double openingAvailableBalance, List<Transaction> transactions) {
        super();
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.openingAvailableBalance = openingAvailableBalance;
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountType="
                + accountType + ", balanceDate=" + balanceDate + ", currency=" + currency + ", openingAvailableBalance="
                + openingAvailableBalance + ", transactions=" + transactions + "]";
    }
}

