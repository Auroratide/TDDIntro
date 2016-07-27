package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by Timothy Foster on 27 Jul 2016.
 *
 * For now we assume all balances are integer values (in whole dollars).
 */
public class Account {

/*  Constructors
 *  =========================================================================*/
    public Account() {
        this(0);
    }

    public Account(int initialBalance) {
        balance = initialBalance;
    }
 
/*  Accessors
 *  =========================================================================*/ 
    public int getBalance() {
        return balance;
    }
 
/*  Public Methods
 *  =========================================================================*/
    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
 
/*  Private Members
 *  =========================================================================*/
    private int balance;


}