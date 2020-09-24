package com.cheung.lib2018midterm;

import java.util.Date;

//starting code
/*
public class Account {

}

 */

public class Account implements  Comparable<Account> {
    private String id = null;
    private double balance =0;
    private Date dateCreated = null;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();

    }

    public String getId() {
        return this.id;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "Account:"+this.id;
    }

    public int compareTo(Account a) {
        if (this.balance > a.balance)
            return 1;
        else if (this.balance < a.balance)
            return -1;
        else
            return 0;

    }

}
