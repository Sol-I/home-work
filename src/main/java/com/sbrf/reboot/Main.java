package com.sbrf.reboot;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String tmpSRC = "src/main/resources/Accounts.txt";
        AccountRepositoryImpl repository = new AccountRepositoryImpl(tmpSRC);
        repository.updateAccounts(2, "5-ACC1NUM", "777-ACCNUM");
        Set<Account> accounts = repository.getAllAccountsByClientId(2L);
        for (Account acc : accounts) {
            System.out.println(acc.getNumber());
        }
    }
}
