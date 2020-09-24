package com.cheung.lib2018midterm;

import java.util.Comparator;
//starting code
/*
public class AccountComparator {

}

 */


public class AccountComparator implements Comparator<Account> {
    public int compare(Account a, Account b) {

        return (a.getId()).compareTo(b.getId());
    }
}
